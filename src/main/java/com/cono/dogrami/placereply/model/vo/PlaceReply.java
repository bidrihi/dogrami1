package com.cono.dogrami.placereply.model.vo;

import java.sql.Date;

public class PlaceReply implements java.io.Serializable {

	private static final long serialVersionUID = 8L;

	private int rep_no; 			// 댓글번호
	private int board_no; 			// 원글번호
	private String rep_writer; 		// 댓글작성자
	private String rep_content; 	// 댓글내용
	private java.sql.Date rep_date; // 댓글날짜
	
	public PlaceReply() {
		super();
	}

	public PlaceReply(int rep_no, int board_no, String rep_writer, String rep_content, Date rep_date) {
		super();
		this.rep_no = rep_no;
		this.board_no = board_no;
		this.rep_writer = rep_writer;
		this.rep_content = rep_content;
		this.rep_date = rep_date;
	}

	public int getRep_no() {
		return rep_no;
	}

	public void setRep_no(int rep_no) {
		this.rep_no = rep_no;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getRep_writer() {
		return rep_writer;
	}

	public void setRep_writer(String rep_writer) {
		this.rep_writer = rep_writer;
	}

	public String getRep_content() {
		return rep_content;
	}

	public void setRep_content(String rep_content) {
		this.rep_content = rep_content;
	}

	public java.sql.Date getRep_date() {
		return rep_date;
	}

	public void setRep_date(java.sql.Date rep_date) {
		this.rep_date = rep_date;
	}

	@Override
	public String toString() {
		return "PlaceReply [rep_no=" + rep_no + ", board_no=" + board_no + ", rep_writer=" + rep_writer
				+ ", rep_content=" + rep_content + ", rep_date=" + rep_date + "]";
	}

	
}
