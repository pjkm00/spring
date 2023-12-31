package kr.or.dw.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {

	public String id;
	public String pwd;
	public String email;
	public String picture;
	public int enabled;
	public Date regdate;
	public String phone;
	public String name;
	public String register;
	public String address;
	public String authority;
	
	public MemberVO() {};
	
	public MemberVO(String id, String pwd, String name, String phone, String email) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	
}