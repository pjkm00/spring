package kr.or.dw.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.dw.vo.MenuVO;
import kr.or.dw.vo.PdsVO;

@Mapper
public interface PdsDAO {

	int insertPds(PdsVO pds) throws SQLException;

}
