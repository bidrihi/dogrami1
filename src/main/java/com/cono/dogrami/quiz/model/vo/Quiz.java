package com.cono.dogrami.quiz.model.vo;

import java.sql.Date;

public class Quiz implements java.io.Serializable {

	private static final long serialVersionUID = 4L;
	
	private String user_id;
	private int quiz_no;
	private String quiz;
	private String quiz_right;
	private String quiz_explain;
	private Date quiz_date;
	private int quiz_count;
	private int like_count;
	private String randomquiz;
	
	public Quiz() {
		super();
	}

	public Quiz(String user_id, int quiz_no, String quiz, String quiz_right, String quiz_explain, Date quiz_date,
			int quiz_count, int like_count, String randomquiz) {
		super();
		this.user_id = user_id;
		this.quiz_no = quiz_no;
		this.quiz = quiz;
		this.quiz_right = quiz_right;
		this.quiz_explain = quiz_explain;
		this.quiz_date = quiz_date;
		this.quiz_count = quiz_count;
		this.like_count = like_count;
		this.randomquiz = randomquiz;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getQuiz_no() {
		return quiz_no;
	}

	public void setQuiz_no(int quiz_no) {
		this.quiz_no = quiz_no;
	}

	public String getQuiz() {
		return quiz;
	}

	public void setQuiz(String quiz) {
		this.quiz = quiz;
	}

	public String getQuiz_right() {
		return quiz_right;
	}

	public void setQuiz_right(String quiz_right) {
		this.quiz_right = quiz_right;
	}

	public String getQuiz_explain() {
		return quiz_explain;
	}

	public void setQuiz_explain(String quiz_explain) {
		this.quiz_explain = quiz_explain;
	}

	public Date getQuiz_date() {
		return quiz_date;
	}

	public void setQuiz_date(Date quiz_date) {
		this.quiz_date = quiz_date;
	}

	public int getQuiz_count() {
		return quiz_count;
	}

	public void setQuiz_count(int quiz_count) {
		this.quiz_count = quiz_count;
	}

	public int getLike_count() {
		return like_count;
	}

	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}

	public String getRandomquiz() {
		return randomquiz;
	}

	public void setRandomquiz(String randomquiz) {
		this.randomquiz = randomquiz;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Quiz [user_id=" + user_id + ", quiz_no=" + quiz_no + ", quiz=" + quiz + ", quiz_right=" + quiz_right
				+ ", quiz_explain=" + quiz_explain + ", quiz_date=" + quiz_date + ", quiz_count=" + quiz_count
				+ ", like_count=" + like_count + ", randomquiz=" + randomquiz + "]";
	}
	
	
	
}
