package kr.or.dw.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.dw.vo.MemberVO;

@Mapper
public interface MemberDAO {

	//회원정보조회
	MemberVO selectMemberById(String id) throws SQLException;

	//회원목록조회
	List<MemberVO> getMemberList() throws SQLException;

	//회원등록
	void insertMember(MemberVO member) throws SQLException;

	//회원수정
	void updateMember(MemberVO member) throws SQLException;

	//회원삭제
	void deleteMember(String id) throws SQLException;

	//회원정지
	void stopMember(String id) throws SQLException;

	//회원정지 해제
	void stopCancelMember(String id) throws SQLException;
}
