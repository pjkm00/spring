package kr.or.dw.command;

import kr.or.dw.vo.MemberVO;
import lombok.Data;

@Data
public class MemberRegistCommand {

	public String id;
	public String pwd;
	public String email;
	public String picture;
	public String[] phone;
	public String name;
	public String authority;
	
	public MemberVO toMemberVO() {
		String phone = "";
		
		for(String data : this.phone) {
			phone += data;
		};
		
		//MemberVO setting
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		member.setEmail(email);
		member.setName(name);
		member.setPicture(picture);
		member.setPhone(phone);
		member.setAuthority(authority);
		
		return member;
	}
}
