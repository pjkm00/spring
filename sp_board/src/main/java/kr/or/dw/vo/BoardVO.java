package kr.or.dw.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {

	public int bno;
	public String title;
	public String content;
	public String writer;
	public Date regdate;
	public int viewcnt;
	public Date updatedate;
	
	public BoardVO() {};

	public BoardVO(int bno, String title, String content, String writer, Date regdate, int viewcnt, Date updatedate) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.viewcnt = viewcnt;
		this.updatedate = updatedate;
	};
	
}
