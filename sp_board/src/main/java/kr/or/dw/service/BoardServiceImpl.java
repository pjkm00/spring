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
import kr.or.dw.dao.BoardDAO;
import kr.or.dw.dao.MemberDAO;
import kr.or.dw.vo.BoardVO;
import kr.or.dw.vo.MemberVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO boardDAO;

	@Override
	public Map<String, Object> selectBoardList(SearchCriteria cri) throws SQLException {
		
		List<BoardVO> boardList = null;
		
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		//현재 페이지 번호에 맞는 리스트를 perPageNum 개수만큼 가져오기
		boardList = boardDAO.selectSearchBoardList(cri, rowBounds);
		
		//전체 board 개수
		int totalCount = boardDAO.selectSearchBoardListCount(cri);
		
		//PageMaker 생성
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		dataMap.put("boardList", boardList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}
	
	

}
