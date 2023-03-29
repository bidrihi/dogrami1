package com.cono.dogrami.dog.model.vo;

public class Dog implements java.io.Serializable {
    private static final long serialVersionUID = 282061348880341355L;
    private String dog_type;	//품종
	private String dog_size;	//크기
	private String dog_hair;	//털빠짐
	private String dog_stamina;		//활동량
	private String dog_char;	//성격
	private String dog_loc;		//원산지
	private String dog_img;		//이미지
	private String dog_info;	//상세정보
	
	public Dog() {
		super();
	}

	public Dog(String dog_type, String dog_size, String dog_hair, String dog_stamina, String dog_char, String dog_loc,
			String dog_img, String dog_info) {
		super();
		this.dog_type = dog_type;
		this.dog_size = dog_size;
		this.dog_hair = dog_hair;
		this.dog_stamina = dog_stamina;
		this.dog_char = dog_char;
		this.dog_loc = dog_loc;
		this.dog_img = dog_img;
		this.dog_info = dog_info;
	}

	public String getDog_type() {
		return dog_type;
	}

	public void setDog_type(String dog_type) {
		this.dog_type = dog_type;
	}

	public String getDog_size() {
		return dog_size;
	}

	public void setDog_size(String dog_size) {
		this.dog_size = dog_size;
	}

	public String getDog_hair() {
		return dog_hair;
	}

	public void setDog_hair(String dog_hair) {
		this.dog_hair = dog_hair;
	}

	public String getDog_stamina() {
		return dog_stamina;
	}

	public void setDog_stamina(String dog_stamina) {
		this.dog_stamina = dog_stamina;
	}

	public String getDog_char() {
		return dog_char;
	}

	public void setDog_char(String dog_char) {
		this.dog_char = dog_char;
	}

	public String getDog_loc() {
		return dog_loc;
	}

	public void setDog_loc(String dog_loc) {
		this.dog_loc = dog_loc;
	}

	public String getDog_img() {
		return dog_img;
	}

	public void setDog_img(String dog_img) {
		this.dog_img = dog_img;
	}

	public String getDog_info() {
		return dog_info;
	}

	public void setDog_info(String dog_info) {
		this.dog_info = dog_info;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Dog [dog_type=" + dog_type + ", dog_size=" + dog_size + ", dog_hair=" + dog_hair + ", dog_stamina="
				+ dog_stamina + ", dog_char=" + dog_char + ", dog_loc=" + dog_loc + ", dog_img=" + dog_img
				+ ", dog_info=" + dog_info + "]";
	}
}
