package com.cono.dogrami.randomquiz.model.vo;

import java.util.ArrayList;

public class RandomQuiz implements java.io.Serializable {

	private static final long serialVersionUID = 25L;

	private int rd_num;
	private String rd_quiz;
	private String rd_answer;
	private String rd_explain;
	
	
	public RandomQuiz() {
		super();
	}
	
	public RandomQuiz(String rd_quiz , String rd_explain) {
		super();
		this.rd_quiz = rd_quiz;
		this.rd_explain = rd_explain;
	}


	public RandomQuiz(int rd_num, String rd_quiz, String rd_answer, String rd_explain) {
		super();
		this.rd_num = rd_num;
		this.rd_quiz = rd_quiz;
		this.rd_answer = rd_answer;
		this.rd_explain = rd_explain;
	}


	public int getRd_num() {
		return rd_num;
	}


	public void setRd_num(int rd_num) {
		this.rd_num = rd_num;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "RandomQuiz [rd_num=" + rd_num + ", rd_quiz=" + rd_quiz + ", rd_answer=" + rd_answer + ", rd_explain="
				+ rd_explain + "]";
	}

	
}
	
	
	
	
	

