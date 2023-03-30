package com.cono.dogrami.randomquiz.model.vo;

import java.util.ArrayList;

public class RandomQuiz implements java.io.Serializable {

	private static final long serialVersionUID = 25L;

	private String rd_quiz;
	private String rd_answer;
	private String rd_explain;
	private int rd_count;
	
	public RandomQuiz() {
		super();
	}
	
	public RandomQuiz(String rd_quiz, String rd_answer, String rd_explain, int rd_count) {
		super();
		this.rd_quiz = rd_quiz;
		this.rd_answer = rd_answer;
		this.rd_explain = rd_explain;
		this.rd_count = rd_count;
	}
	
	
	public String getRd_quiz() {
		return rd_quiz;
	}
	public void setRd_quiz(String rd_quiz) {
		this.rd_quiz = rd_quiz;
	}
	public String getRd_answer() {
		return rd_answer;
	}
	public void setRd_answer(String rd_answer) {
		this.rd_answer = rd_answer;
	}
	public String getRd_explain() {
		return rd_explain;
	}
	public void setRd_explain(String rd_explain) {
		this.rd_explain = rd_explain;
	}
	public int getRd_count() {
		return rd_count;
	}
	public void setRd_count(int rd_count) {
		this.rd_count = rd_count;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	@Override
	public String toString() {
		return "RandomQuiz [rd_quiz=" + rd_quiz + ", rd_answer=" + rd_answer + ", rd_explain=" + rd_explain
				+ ", rd_count=" + rd_count + "]";
	}

	
	}
	
	
	
	
	

