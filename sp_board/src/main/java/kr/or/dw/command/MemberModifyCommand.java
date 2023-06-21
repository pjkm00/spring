package kr.or.dw.command;

import org.springframework.web.multipart.MultipartFile;

import kr.or.dw.vo.MemberVO;
import lombok.Data;

@Data
public class MemberModifyCommand {

	public String id;
	public String pwd;
	public String email;
	public String phone;
	public String name;
	public String authority;
	public String oldPicture;
	public String uploadPicture;
	public MultipartFile picture;
	
	public MemberVO toParseMember() {
		MemberVO member = new MemberVO();
		
		member.setId(id);
		member.setPwd(pwd);
		member.setName(name);
		member.setPhone(phone.replace("-", ""));
		member.setEmail(email);
		member.setAuthority(authority);
		
		return member;
	}
	
	
}
