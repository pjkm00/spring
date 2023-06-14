package kr.or.dw.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.dw.vo.MenuVO;

@Mapper
public interface MenuDAO {
	
	List<MenuVO> selectMainMenuList() throws SQLException;
	
	List<MenuVO> selectSubMenuList(String mcode) throws SQLException;
}
