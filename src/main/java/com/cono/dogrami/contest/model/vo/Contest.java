package com.cono.dogrami.contest.model.vo;

import java.sql.Date;

import com.cono.dogrami.member.model.vo.Member;

public class Contest implements java.io.Serializable {
    private static final long serialVersionUID = 24L;
    
    private String user_id;
    private int contest_no;
    private String contest_title;
    private String contest_content;
    private Date contest_date;
    private int contest_count;
    private int like_count;
    private String contest_oldfile;
    private String contest_newfile;
    private String grade_first;
    private Member member;

    
    public Contest() {
		super();
	}


	public Contest(String user_id, int contest_no, String contest_title, String contest_content, Date contest_date,
			int contest_count, int like_count, String contest_oldfile, String contest_newfile, String grade_first,
			Member member) {
		super();
		this.user_id = user_id;
		this.contest_no = contest_no;
		this.contest_title = contest_title;
		this.contest_content = contest_content;
		this.contest_date = contest_date;
		this.contest_count = contest_count;
		this.like_count = like_count;
		this.contest_oldfile = contest_oldfile;
		this.contest_newfile = contest_newfile;
		this.grade_first = grade_first;
		this.member = member;
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


	public String getContest_title() {
		return contest_title;
	}


	public void setContest_title(String contest_title) {
		this.contest_title = contest_title;
	}


	public String getContest_content() {
		return contest_content;
	}


	public void setContest_content(String contest_content) {
		this.contest_content = contest_content;
	}


	public Date getContest_date() {
		return contest_date;
	}


	public void setContest_date(Date contest_date) {
		this.contest_date = contest_date;
	}


	public int getContest_count() {
		return contest_count;
	}


	public void setContest_count(int contest_count) {
		this.contest_count = contest_count;
	}


	public int getLike_count() {
		return like_count;
	}


	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}


	public String getContest_oldfile() {
		return contest_oldfile;
	}


	public void setContest_oldfile(String contest_oldfile) {
		this.contest_oldfile = contest_oldfile;
	}


	public String getContest_newfile() {
		return contest_newfile;
	}


	public void setContest_newfile(String contest_newfile) {
		this.contest_newfile = contest_newfile;
	}


	public String getGrade_first() {
		return grade_first;
	}


	public void setGrade_first(String grade_first) {
		this.grade_first = grade_first;
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
		return "Contest [user_id=" + user_id + ", contest_no=" + contest_no + ", contest_title=" + contest_title
				+ ", contest_content=" + contest_content + ", contest_date=" + contest_date + ", contest_count="
				+ contest_count + ", like_count=" + like_count + ", contest_oldfile=" + contest_oldfile
				+ ", contest_newfile=" + contest_newfile + ", grade_first=" + grade_first + ", member=" + member + "]";
	}

    
    
    
}
