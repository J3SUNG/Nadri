package com.ssafy.trip.model.dto;

public class AttractionDto {
	private int attractionNo;
	private int contentType;
	private String title;
	private String addr1;
	private String addr2;
	private String zipcode;
	private String tel;
	private String image1;
	private String image2;
	private double latitude;
	private double longitude;
	private String overview;
	private int sidoCode;
	private int gugunCode;
	
	public AttractionDto(int attractionNo, int contentType, String title, String addr1, String addr2, String zipcode,
			String tel, String image1, String image2, double latitude, double longitude, String overview, int sidoCode,
			int gugunCode) {
		super();
		this.attractionNo = attractionNo;
		this.contentType = contentType;
		this.title = title;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.zipcode = zipcode;
		this.tel = tel;
		this.image1 = image1;
		this.image2 = image2;
		this.latitude = latitude;
		this.longitude = longitude;
		this.overview = overview;
		this.sidoCode = sidoCode;
		this.gugunCode = gugunCode;
	}
	public int getAttractionNo() {
		return attractionNo;
	}
	public void setAttractionNo(int attractionNo) {
		this.attractionNo = attractionNo;
	}
	public int getContentType() {
		return contentType;
	}
	public void setContentType(int contentType) {
		this.contentType = contentType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public String getImage2() {
		return image2;
	}
	public void setImage2(String image2) {
		this.image2 = image2;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public int getSidoCode() {
		return sidoCode;
	}
	public void setSidoCode(int sidoCode) {
		this.sidoCode = sidoCode;
	}
	public int getGugunCode() {
		return gugunCode;
	}
	public void setGugunCode(int gugunCode) {
		this.gugunCode = gugunCode;
	}
	@Override
	public String toString() {
		return "AttractionDto [attractionNo=" + attractionNo + ", contentType=" + contentType + ", title=" + title
				+ ", addr1=" + addr1 + ", addr2=" + addr2 + ", zipcode=" + zipcode + ", tel=" + tel + ", image1="
				+ image1 + ", image2=" + image2 + ", latitude=" + latitude + ", longitude=" + longitude + ", overview="
				+ overview + ", sidoCode=" + sidoCode + ", gugunCode=" + gugunCode + "]";
	}
}
