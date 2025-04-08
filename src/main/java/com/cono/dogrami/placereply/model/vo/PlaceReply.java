package com.cono.dogrami.placereply.model.vo;

import java.sql.Date;

import com.cono.dogrami.member.model.vo.Member;

public class PlaceReply implements java.io.Serializable {

	private static final long serialVersionUID = 8L;

	private int ref_no; 			// 댓글번호
	private int board_no; 			// 원글번호
	private String ref_writer; 		// 댓글작성자
	private String ref_content; 	// 댓글내용
	private Date ref_date; // 댓글날짜
	private Member member;
	
	public PlaceReply() {
		super();
	}

	public PlaceReply(int ref_no, int board_no, String ref_writer, String ref_content, Date ref_date, Member member) {
		super();
		this.ref_no = ref_no;
		this.board_no = board_no;
		this.ref_writer = ref_writer;
		this.ref_content = ref_content;
		this.ref_date = ref_date;
		this.member = member;
	}

	public int getRef_no() {
		return ref_no;
	}

	public void setRep_no(int ref_no) {
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

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PlaceReply [ref_no=" + ref_no + ", board_no=" + board_no + ", ref_writer=" + ref_writer
				+ ", ref_content=" + ref_content + ", ref_date=" + ref_date + ", member=" + member + "]";
	}

	

	
}
