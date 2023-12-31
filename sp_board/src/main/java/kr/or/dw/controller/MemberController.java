package kr.or.dw.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.or.dw.command.MemberModifyCommand;
import kr.or.dw.command.MemberRegistCommand;
import kr.or.dw.command.SearchCriteria;
import kr.or.dw.service.MemberService;
import kr.or.dw.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/main")
	public String main() {
		String url = "/member/main.open";
		return url;
	}
	
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mnv, SearchCriteria cri) throws SQLException{
		String url = "/member/list.open";
		
		Map<String, Object> dataMap = memberService.getSearchMemberList(cri);

		mnv.addAllObjects(dataMap);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	//회원등록 양식
	@RequestMapping("/registForm")
	public String registForm() {
		String url = "/member/regist.open";
		return url;
	}
	
	//회원등록
	@RequestMapping("/regist")
	public void regist(MemberRegistCommand memberReq, HttpServletRequest req, HttpServletResponse res) throws Exception {
		MemberVO member = memberReq.toMemberVO();
		
		memberService.regist(member);
		
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<script>");
		out.println("alert('회원등록이 정상적으로 되었습니다.')");
		out.println("window.opener.location.href='" + req.getContextPath() + "/member/list.do';");
		out.println("window.close();");
		out.println("</script>");
		out.close();
	}
	
	//아이디 중복 확인
	@RequestMapping("/idCheck")
	public ResponseEntity<String> idCheck(String id, HttpServletRequest req){
		
		ResponseEntity<String> entity = null;
		 try {
			MemberVO member = memberService.selectMemberById(id);
			entity = new ResponseEntity<String>(member == null ? id : "", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@RequestMapping("/detail")
	public ModelAndView detail(String id, ModelAndView mnv, HttpServletResponse res) throws Exception {
		
		MemberVO member = memberService.selectMemberById(id);

		String url = "/member/detail.open";
		mnv.addObject("member", member);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping("/modifyForm")
	public ModelAndView modifyForm(String id, ModelAndView mnv) throws SQLException {
		
		MemberVO member = memberService.selectMemberById(id);

		String url = "/member/modify.open";
		mnv.addObject("member", member);
		mnv.setViewName(url);
		
		return mnv; 
	}
	
	@RequestMapping("/modify")
	public void modify(MemberModifyCommand modifyReq, HttpServletRequest req, HttpServletResponse res) throws Exception {
		MemberVO member = modifyReq.toParseMember();
		
		String fileName = savePicture(modifyReq.getPicture(), modifyReq.getOldPicture());
		
		member.setPicture(fileName);
		
		if(modifyReq.getPicture().isEmpty()) {
			member.setPicture(modifyReq.getOldPicture());
		};
		
		memberService.modify(member);
		
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<script>");
		out.println("alert('수정되었습니다.');");
		out.println("location.href='detail.do?id=" + member.getId() + "';");
		out.println("window.opener.parent.location.reload();");
		out.println("</script>");
		out.close();
		
	}
	
	@RequestMapping("/delete")
	public void delete(HttpServletRequest req, HttpServletResponse res, String id) throws Exception {
		memberService.deleteMember(id);
		
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<script>");
		out.println("alert('삭제되었습니다.')");
		out.println("window.opener.location.href='" + req.getContextPath() + "/member/list.do';");
		out.println("window.close();");
		out.println("</script>");
		out.close();
		
	}
	
	@RequestMapping("/remove")
	public ModelAndView remove(String id, HttpSession session, ModelAndView mnv) throws SQLException {
		String url = "/member/removeSuccess";
		
		MemberVO member = null;
		
		//이미지파일 삭제
		member = memberService.selectMemberById(id);
		
		String savePath = this.picturePath;
		File imageFile = new File(savePath, member.getPicture());
		if(imageFile.exists()) {
			imageFile.delete();
		}
		
		memberService.deleteMember(id);
		
		//삭제되는 회원이 로그인한 회원인 경우 로그아웃 시켜야함.
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(loginUser.getId().equals(member.getId())) {
			session.invalidate();
		};
		
		mnv.addObject("member", member);
		mnv.setViewName(url);
		
		return mnv;
		
	}
	
//	@RequestMapping("/stop")
//	public void stop(HttpServletRequest req, HttpServletResponse res, String id) throws Exception {
//		memberService.stopMember(id);
//		
//		res.setContentType("text/html; charset=utf-8");
//		PrintWriter out = res.getWriter();
//		out.println("<script>");
//		out.println("alert('정지되었습니다.')");
//		out.println("window.opener.location.href='" + req.getContextPath() + "/member/list.do';");
//		out.println("window.close();");
//		out.println("</script>");
//		out.close();
//	}
	@RequestMapping("/stop")
	public ModelAndView stop(String id, HttpSession session, ModelAndView mnv) throws SQLException {
		String url = "/member/stopSuccess";
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(id.equals(loginUser.getId())) {
			url = "/member/stopFail";
		}else {
			memberService.stopMember(id);
		}
		
		mnv.addObject("id", id);
		mnv.addObject("msg", "정지");
		mnv.setViewName(url);
		
		return mnv;
	}
	
//	@RequestMapping("/stopCancel")
//	public void stopCancel(HttpServletRequest req, HttpServletResponse res, String id) throws Exception {
//		memberService.stopCancelMember(id);
//		
//		res.setContentType("text/html; charset=utf-8");
//		PrintWriter out = res.getWriter();
//		out.println("<script>");
//		out.println("alert('정지해제가 되었습니다.')");
//		out.println("location.href='" + req.getContextPath() + "/member/detail.do?id=" + id +"';");
//		out.println("</script>");
//		out.close();
//	}
	@RequestMapping("/stopCancel")
	public ModelAndView stopCancel(String id, ModelAndView mnv) throws SQLException {
		String url = "/member/stopSuccess";
		
		memberService.stopCancelMember(id);
		
		mnv.addObject("id", id);
		mnv.addObject("msg", "정지해제");
		mnv.setViewName(url);
		
		return mnv;
	}
	
	//사진 업로드
	@RequestMapping("/picture")
	public ResponseEntity<String> picture(@RequestParam("pictureFile") MultipartFile multi, String oldPicture) throws Exception{
		ResponseEntity<String> entity = null;
		
		String result = "";
		HttpStatus status = null;
		
		if((result = savePicture(multi, oldPicture)) == null) {
			result = "업로드를 실패했습니다.";
			status = HttpStatus.BAD_REQUEST;
		}else {
			status = HttpStatus.OK;
		}
		
		entity = new ResponseEntity<String>(result, status);
		
		
 		return entity;
	}
	
	@Resource(name = "picturePath")
	private String picturePath;
	
	/*
	 * @Resource는 @AutoWired와 같이 property injection을 위한 어노테이션이다.
	 * 차이점은 
	 * @AuthWired는 객체 타입을 보고 맵핑 된다면
	 * @Resource는 객체 name(id)를 보고 맵핑이 된다.
	 * 괄호에 객체 name을 명시하지 않으면 @AutoWired처럼 해당 레퍼런스변수의 타입과 똑같은 객체 name을 찾는다.
	 */
	
	private String savePicture(MultipartFile multi, String oldPicture) throws Exception {
		
		String fileName = null;
		
		/* 파일 유무 확인 */
		if(!(multi == null || multi.isEmpty() || multi.getSize() > 1024 * 1024 * 1)) {
			/*파일 저장 폴더 설정	*/
			String uploadPath = picturePath;
			fileName = UUID.randomUUID().toString().replace("-", "") + ".jpg";
			File storeFile = new File(uploadPath, fileName);
			
			storeFile.mkdirs();
			
			//local HDD에 저장.
			multi.transferTo(storeFile);
			
			if(!oldPicture.isEmpty()) {
				File oldFile = new File(uploadPath, oldPicture);
				if(oldFile.exists()) {
					oldFile.delete();
				};
			};
			
		}
		
		return fileName;
	}
	
	@RequestMapping("/getMemberToJson")
	public ResponseEntity<MemberVO> getMemberToJson(String id) throws SQLException{
		
		ResponseEntity<MemberVO> entity = null;
		
		MemberVO member = memberService.selectMemberById(id);
		
		entity = new ResponseEntity<MemberVO>(member, HttpStatus.OK);
		
		return entity;
	
	}
	
	@RequestMapping("/getPicture")
	public ResponseEntity<byte[]> getPicture(String picture) throws Exception{
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		String imgPath = this.picturePath;
		
		try {
			in = new FileInputStream(new File(imgPath, picture));
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), HttpStatus.CREATED);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}finally {
			in.close();
		}
		
		return entity;
	}
	
	
	
}

