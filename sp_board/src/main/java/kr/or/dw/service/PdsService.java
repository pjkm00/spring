package kr.or.dw.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.dw.vo.MenuVO;
import kr.or.dw.vo.PdsVO;

public interface PdsService {

	void regist(PdsVO pds) throws SQLException;

	
}
