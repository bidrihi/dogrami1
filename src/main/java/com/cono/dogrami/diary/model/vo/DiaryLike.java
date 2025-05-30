package com.cono.dogrami.diary.model.vo;

public class DiaryLike implements java.io.Serializable{

	private static final long serialVersionUID = -1083128503292660258L;

	private int board_no;
	private String user_id;
	
	public DiaryLike() {}

	public DiaryLike(int board_no, String user_id) {
		super();
		this.board_no = board_no;
		this.user_id = user_id;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DiaryLike [board_no=" + board_no + ", user_id=" + user_id + "]";
	}
	
	
}
