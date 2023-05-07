package com.ssafy.trip.model.dto;

public class UserDto {	
	private String userNo;
	private String id;
	private String name;
	private String password;
	private String email;
	private int age;
	private String gender;
	private String join_date;
	private String grade;
	private int sidoNo;
	private int gugunNo;

	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getJoin_date() {
		return join_date;
	}
	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getSidoNo() {
		return sidoNo;
	}
	public void setSidoNo(int sidoNo) {
		this.sidoNo = sidoNo;
	}
	public int getGugunNo() {
		return gugunNo;
	}
	public void setGugunNo(int gugunNo) {
		this.gugunNo = gugunNo;
	}
	@Override
	public String toString() {
		return "UserDto [userNo=" + userNo + ", id=" + id + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", age=" + age + ", gender=" + gender + ", join_date=" + join_date + ", grade=" + grade + ", sidoNo=" + sidoNo
				+ ", gugunNo=" + gugunNo + "]";
	}
}
