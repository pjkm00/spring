package kr.or.dw.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {

	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private int viewcnt;
	private Date updatedate;
	private int replycnt;	//댓글개수
	
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
