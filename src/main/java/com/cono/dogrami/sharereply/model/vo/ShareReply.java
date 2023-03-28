package com.cono.dogrami.sharereply.model.vo;

import java.sql.Date;

public class ShareReply implements java.io.Serializable{

	private static final long serialVersionUID = 18L;
	
	private int ref_no;
	private int board_no;
	private String ref_writer;
	private String ref_content;
	private Date ref_date;
	
	public ShareReply() {}

	public ShareReply(int ref_no, int board_no, String ref_writer, String ref_content, Date ref_date) {
		super();
		this.ref_no = ref_no;
		this.board_no = board_no;
		this.ref_writer = ref_writer;
		this.ref_content = ref_content;
		this.ref_date = ref_date;
	}

	public int getRef_no() {
		return ref_no;
	}

	public void setRef_no(int ref_no) {
		this.ref_no = ref_no;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getRef_writer() {
		return ref_writer;
	}

	public void setRef_writer(String ref_writer) {
		this.ref_writer = ref_writer;
	}

	public String getRef_content() {
		return ref_content;
	}

	public void setRef_content(String ref_content) {
		this.ref_content = ref_content;
	}

	public Date getRef_date() {
		return ref_date;
	}

	public void setRef_date(Date ref_date) {
		this.ref_date = ref_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ShareReply [ref_no=" + ref_no + ", board_no=" + board_no + ", ref_writer=" + ref_writer
				+ ", ref_content=" + ref_content + ", ref_date=" + ref_date + "]";
	}
	
	
}
