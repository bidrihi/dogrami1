package com.cono.dogrami.restaurant.model.vo;

public class Restaurant implements java.io.Serializable{

	private static final long serialVersionUID = 16L;
	
	private String name;		//장례업체명
	    private String address;		//소재지 주소
	    private String address2;	//도로명 주소
	    private String phone;		//전화번호
	    private String latitude;	//위도
	    private String longitude;	//경도
		
	    public Restaurant() {
			super();
		}

		public Restaurant(String name, String address, String address2, String phone, String latitude,
				String longitude) {
			super();
			this.name = name;
			this.address = address;
			this.address2 = address2;
			this.phone = phone;
			this.latitude = latitude;
			this.longitude = longitude;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getAddress2() {
			return address2;
		}

		public void setAddress2(String address2) {
			this.address2 = address2;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getLatitude() {
			return latitude;
		}

		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}

		public String getLongitude() {
			return longitude;
		}

		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public String toString() {
			return "Restaurant [name=" + name + ", address=" + address + ", address2=" + address2 + ", phone=" + phone
					+ ", latitude=" + latitude + ", longitude=" + longitude + "]";
		}
	    
	    
	    
}
