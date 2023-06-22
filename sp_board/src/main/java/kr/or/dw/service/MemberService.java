package kr.or.dw.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import kr.or.dw.command.SearchCriteria;
import kr.or.dw.vo.MemberVO;

public interface MemberService {
	
	//로그인
	void login(String id, String pwd, HttpSession session) throws SQLException;

	//회원정보 조회
	List<MemberVO> getMemberList() throws SQLException;

	//아이디 중복확인
	MemberVO selectMemberById(String id) throws SQLException;

	//회원등록
	void regist(MemberVO member) throws SQLException;

	//회원수정
	void modify(MemberVO member) throws SQLException;

	//회원 삭제
	void deleteMember(String id) throws SQLException;

	//회원 정지
	void stopMember(String id) throws SQLException;

	//회원정지해제
	void stopCancelMember(String id) throws SQLException;

	//회원검색하여 리스트
	Map<String, Object> getSearchMemberList(SearchCriteria cri) throws SQLException;
}
