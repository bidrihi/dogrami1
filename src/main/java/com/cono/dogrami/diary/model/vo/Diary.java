package com.cono.dogrami.diary.model.vo;

import java.sql.Date;

public class Diary implements java.io.Serializable {
    private static final long serialVersionUID = 23L;
    
    private int board_no;
	private String title;
	private String board_writer;
	private String board_content;
	private String board_old_file;
	private String board_new_file;
	private Date BOARD_DATE;
	private int board_count;
	private int like_count;
	private char open;
	
	public Diary() {}

	public Diary(int board_no, String title, String board_writer, String board_content, String board_old_file,
			String board_new_file, Date bOARD_DATE, int board_count, int like_count, char open) {
		super();
		this.board_no = board_no;
		this.title = title;
		this.board_writer = board_writer;
		this.board_content = board_content;
		this.board_old_file = board_old_file;
		this.board_new_file = board_new_file;
		BOARD_DATE = bOARD_DATE;
		this.board_count = board_count;
		this.like_count = like_count;
		this.open = open;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBoard_writer() {
		return board_writer;
	}

	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public String getBoard_old_file() {
		return board_old_file;
	}

	public void setBoard_old_file(String board_old_file) {
		this.board_old_file = board_old_file;
	}

	public String getBoard_new_file() {
		return board_new_file;
	}

	public void setBoard_new_file(String board_new_file) {
		this.board_new_file = board_new_file;
	}

	public Date getBOARD_DATE() {
		return BOARD_DATE;
	}

	public void setBOARD_DATE(Date bOARD_DATE) {
		BOARD_DATE = bOARD_DATE;
	}

	public int getBoard_count() {
		return board_count;
	}

	public void setBoard_count(int board_count) {
		this.board_count = board_count;
	}

	public int getLike_count() {
		return like_count;
	}

	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}

	public char getOpen() {
		return open;
	}

	public void setOpen(char open) {
		this.open = open;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Diary [board_no=" + board_no + ", title=" + title + ", board_writer=" + board_writer
				+ ", board_content=" + board_content + ", board_old_file=" + board_old_file + ", board_new_file="
				+ board_new_file + ", BOARD_DATE=" + BOARD_DATE + ", board_count=" + board_count + ", like_count="
				+ like_count + ", open=" + open + "]";
	}
	
    
}
