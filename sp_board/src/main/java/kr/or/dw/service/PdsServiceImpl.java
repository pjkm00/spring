package kr.or.dw.service;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.dw.dao.BoardDAO;
import kr.or.dw.dao.MemberDAO;
import kr.or.dw.dao.PdsDAO;
import kr.or.dw.vo.MemberVO;

@Service
public class PdsServiceImpl implements PdsService{

	@Autowired
	private PdsDAO pdsDAO;
	
	

}