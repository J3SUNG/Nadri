package com.ssafy.trip.model.dto;

public class UserDto {	
	private String userNo;
	private String id;
	private String password;
	private String nickname;
	private String email;
	private String join_date;
	private String grade;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	@Override
	public String toString() {
		return "UserDto [userNo=" + userNo + ", id=" + id + ", password=" + password + ", nickname=" + nickname
				+ ", email=" + email + ", join_date=" + join_date + ", grade=" + grade + "]";
	}
}
