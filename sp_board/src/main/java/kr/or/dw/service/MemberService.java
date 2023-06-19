package kr.or.dw.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import kr.or.dw.vo.MemberVO;

public interface MemberService {
	
	//로그인
	void login(String id, String pwd, HttpSession session) throws SQLException;

	//회원정보 조회
	List<MemberVO> getMemberList() throws SQLException;

	//아이디 중복확인
	MemberVO selectMemberById(String id) throws SQLException;
}
