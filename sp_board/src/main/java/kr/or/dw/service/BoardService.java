package kr.or.dw.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.dw.command.SearchCriteria;
import kr.or.dw.vo.MenuVO;

public interface BoardService {

	Map<String, Object> selectBoardList(SearchCriteria cri) throws SQLException;


}
