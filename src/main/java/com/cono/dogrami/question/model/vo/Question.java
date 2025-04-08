package com.cono.dogrami.question.model.vo;

import java.sql.Date;

import com.cono.dogrami.member.model.vo.Member;

public class Question implements java.io.Serializable {
    private static final long serialVersionUID = 21L;

    private int board_no;
    private String board_title;
    private String board_writer;
    private String board_content;
    private String board_old_file;
    private String board_new_file;
    private Date board_date;
    private int board_count;
    private int like_count;
    private Member member;
    
    public Question() {
    }

	public Question(int board_no, String board_title, String board_writer, String board_content, String board_old_file,
			String board_new_file, Date board_date, int board_count, int like_count, Member member) {
		super();
		this.board_no = board_no;
		this.board_title = board_title;
		this.board_writer = board_writer;
		this.board_content = board_content;
		this.board_old_file = board_old_file;
		this.board_new_file = board_new_file;
		this.board_date = board_date;
		this.board_count = board_count;
		this.like_count = like_count;
		this.member = member;
	}

	


    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getBoard_no() {
        return board_no;
    }

    public void setBoard_no(int board_no) {
        this.board_no = board_no;
    }

    public String getBoard_title() {
        return board_title;
    }

    public void setBoard_title(String board_title) {
        this.board_title = board_title;
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

    public Date getBoard_date() {
        return board_date;
    }

    public void setBoard_date(Date board_date) {
        this.board_date = board_date;
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

    public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Question [board_no=" + board_no + ", board_title=" + board_title + ", board_writer=" + board_writer
				+ ", board_content=" + board_content + ", board_old_file=" + board_old_file + ", board_new_file="
				+ board_new_file + ", board_date=" + board_date + ", board_count=" + board_count + ", like_count="
				+ like_count + ", member=" + member + "]";
	}
	
   

}
