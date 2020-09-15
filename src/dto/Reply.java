package dto;

import java.time.LocalDateTime;

public class Reply {
	
	private int no;
	private int board_no;
	private String content;
	private String writer;
	private LocalDateTime reg_date;
	private int recommend;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public LocalDateTime getReg_date() {
		return reg_date;
	}
	public void setReg_date(LocalDateTime reg_date) {
		this.reg_date = reg_date;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	
	public Reply() {
	}
	public Reply(int board_no, String content, String writer) {
		this.board_no = board_no;
		this.content = content;
		this.writer = writer;
	}
	

}
