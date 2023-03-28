package com.cono.dogrami.careboard.model.vo;

import java.sql.Date;

public class CareBoard implements java.io.Serializable{

	private static final long serialVersionUID = 5L;
	
	private String category;			//카테고리
	private String user_id;				//아이디
	private String location;			//지역
	private int board_no;				//게시글 번호(원글번호)
	private String board_title;			//게시글 제목
	private String board_content;		//게시글 내용
	private	java.sql.Date board_date;	//작성 날짜
	private int board_count;			//조회수
	private String image;				//첨부이미지
	private String new_image;			//수정이미지

	private int star_point;				//별점

	
	public CareBoard() {}


	public CareBoard(String category, String user_id, String location, int board_no, String board_title,
			String board_content, Date board_date, int board_count, String image, String new_image, int star_point) {
		super();
		this.category = category;
		this.user_id = user_id;
		this.location = location;
		this.board_no = board_no;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_date = board_date;
		this.board_count = board_count;
		this.image = image;
		this.new_image = new_image;
		this.star_point = star_point;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
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


	public String getBoard_content() {
		return board_content;
	}


	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}


	public java.sql.Date getBoard_date() {
		return board_date;
	}


	public void setBoard_date(java.sql.Date board_date) {
		this.board_date = board_date;
	}


	public int getBoard_count() {
		return board_count;
	}


	public void setBoard_count(int board_count) {
		this.board_count = board_count;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getNew_image() {
		return new_image;
	}


	public void setNew_image(String new_image) {
		this.new_image = new_image;
	}


	public int getStar_point() {
		return star_point;
	}


	public void setStar_point(int star_point) {
		this.star_point = star_point;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "CareBoard [category=" + category + ", user_id=" + user_id + ", location=" + location + ", board_no="
				+ board_no + ", board_title=" + board_title + ", board_content=" + board_content + ", board_date="
				+ board_date + ", board_count=" + board_count + ", image=" + image + ", new_image=" + new_image
				+ ", star_point=" + star_point + "]";
	}

	
	
}
