package com.cono.dogrami.member.model.vo;

public class Member implements java.io.Serializable{

	private static final long serialVersionUID = 1234568789554184218L;
	
	private String user_name;	//회원 이름
	private String user_nick;	//회원 닉네임
	private String user_id;		//회원 아이디
	private String user_pwd;	//회원 비밀번호
	private String email;		//이메일
	private String birth;		//생년월일
	private String gender;		//성별
	private String user_picture;	//프로필사진
	private String user_picture_rename;	//프로필사진 리네임
	private String dog_name;	//반려견 이름
	private String dog_birth;	//반려견 생년월일
	private String dog_type;	//반려견 종
	private String dog_gender;	//반려견 성별
	private String user_admin;	//관리자 여부
	private String login_limit;	//로그인 제한
	
	public Member() {
		super();
	}

	public Member(String user_name, String user_nick, String user_id, String user_pwd, String email, String birth, String gender, String user_picture, String user_picture_rename, String dog_name, String dog_birth, String dog_type, String dog_gender, String user_admin, String login_limit) {
		this.user_name = user_name;
		this.user_nick = user_nick;
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.email = email;
		this.birth = birth;
		this.gender = gender;
		this.user_picture = user_picture;
		this.user_picture_rename = user_picture_rename;
		this.dog_name = dog_name;
		this.dog_birth = dog_birth;
		this.dog_type = dog_type;
		this.dog_gender = dog_gender;
		this.user_admin = user_admin;
		this.login_limit = login_limit;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_nick() {
		return user_nick;
	}

	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUser_picture() {
		return user_picture;
	}

	public void setUser_picture(String user_picture) {
		this.user_picture = user_picture;
	}

	public String getUser_picture_rename() {
		return user_picture_rename;
	}

	public void setUser_picture_rename(String user_picture_rename) {
		this.user_picture_rename = user_picture_rename;
	}

	public String getDog_name() {
		return dog_name;
	}

	public void setDog_name(String dog_name) {
		this.dog_name = dog_name;
	}

	public String getDog_birth() {
		return dog_birth;
	}

	public void setDog_birth(String dog_birth) {
		this.dog_birth = dog_birth;
	}

	public String getDog_type() {
		return dog_type;
	}

	public void setDog_type(String dog_type) {
		this.dog_type = dog_type;
	}

	public String getDog_gender() {
		return dog_gender;
	}

	public void setDog_gender(String dog_gender) {
		this.dog_gender = dog_gender;
	}

	public String getUser_admin() {
		return user_admin;
	}

	public void setUser_admin(String user_admin) {
		this.user_admin = user_admin;
	}

	public String getLogin_limit() {
		return login_limit;
	}

	public void setLogin_limit(String login_limit) {
		this.login_limit = login_limit;
	}

	@Override
	public String toString() {
		return "Member{" +
				"user_name='" + user_name + '\'' +
				", user_nick='" + user_nick + '\'' +
				", user_id='" + user_id + '\'' +
				", user_pwd='" + user_pwd + '\'' +
				", email='" + email + '\'' +
				", birth='" + birth + '\'' +
				", gender='" + gender + '\'' +
				", user_picture='" + user_picture + '\'' +
				", user_picture_rename='" + user_picture_rename + '\'' +
				", dog_name='" + dog_name + '\'' +
				", dog_birth='" + dog_birth + '\'' +
				", dog_type='" + dog_type + '\'' +
				", dog_gender='" + dog_gender + '\'' +
				", user_admin='" + user_admin + '\'' +
				", login_limit='" + login_limit + '\'' +
				'}';
	}
}
