package kr.or.dw.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.dw.command.PageMaker;
import kr.or.dw.command.SearchCriteria;
import kr.or.dw.dao.MemberDAO;
import kr.or.dw.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO memberDAO;
	
	
	@Override
	public void login(String id, String pwd, HttpSession session) throws SQLException {
		MemberVO member = memberDAO.selectMemberById(id);
		
		if(pwd.equals(member.getPwd())) {
			System.out.println("[로그인성공!] 회원의 정보를 세션에 저장합니다.");
			session.setAttribute("loginUser", member);
			session.setMaxInactiveInterval(5*60);
		}
		
	}


	@Override
	public List<MemberVO> getMemberList() throws SQLException {
		List<MemberVO> memList = null;
		memList = memberDAO.getMemberList();
		return memList;
	}


	@Override
	public MemberVO selectMemberById(String id) throws SQLException{
		MemberVO member = memberDAO.selectMemberById(id);
		return member;
	}


	@Override
	public void regist(MemberVO member) throws SQLException {
		memberDAO.insertMember(member);
		
	}


	@Override
	public void modify(MemberVO member) throws SQLException {
		memberDAO.updateMember(member);
	}


	@Override
	public void deleteMember(String id) throws SQLException {
		memberDAO.deleteMember(id);
	}


	@Override
	public void stopMember(String id) throws SQLException{
		memberDAO.stopMember(id);
	}


	@Override
	public void stopCancelMember(String id) throws SQLException {
		memberDAO.stopCancelMember(id);
	}


	@Override
	public Map<String, Object> getSearchMemberList(SearchCriteria cri) throws SQLException {
		List<MemberVO> memberList = null;
		
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		
		memberList = memberDAO.getSearchMemberList(cri, rowBounds);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(memberDAO.selectSearchMemberListCount(cri));
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		dataMap.put("memberList", memberList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}

}
