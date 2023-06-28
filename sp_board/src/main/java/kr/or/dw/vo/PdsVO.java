package kr.or.dw.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class PdsVO {

	private int pno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private int viewcnt;
	private Date updatedate;
	
	private List<AttachVO> attachList;
	
	
}
