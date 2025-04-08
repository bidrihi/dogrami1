package com.cono.dogrami.careboard.model.vo;

public class CareLike implements java.io.Serializable{

	private static final long serialVersionUID = -873434723164730983L;

	private int board_no;
	private String user_id;
	
	public CareLike() {}

	public CareLike(int board_no, String user_id) {
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
		return "PlaceLike [board_no=" + board_no + ", user_id=" + user_id + "]";
	}
}
