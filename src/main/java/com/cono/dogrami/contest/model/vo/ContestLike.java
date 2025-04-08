package com.cono.dogrami.contest.model.vo;

public class ContestLike implements java.io.Serializable{

	private static final long serialVersionUID = -8437039634640341378L;

	private String user_id;
	private int contest_no;
	public ContestLike() {
		super();
	}
	public ContestLike(String user_id, int contest_no) {
		super();
		this.user_id = user_id;
		this.contest_no = contest_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getContest_no() {
		return contest_no;
	}
	public void setContest_no(int contest_no) {
		this.contest_no = contest_no;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ContestLike [user_id=" + user_id + ", contest_no=" + contest_no + "]";
	}

	
}
