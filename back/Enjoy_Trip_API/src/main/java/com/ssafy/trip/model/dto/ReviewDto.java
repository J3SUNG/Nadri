package com.ssafy.trip.model.dto;

public class ReviewDto {
	private String reviewNo;
	private String content;
	private String createtime;
	private int attractionNo;
	private int userNo;
	private String nickname;
	public String getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(String reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public int getAttractionNo() {
		return attractionNo;
	}
	public void setAttractionNo(int attractionNo) {
		this.attractionNo = attractionNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "ReviewDto [reviewNo=" + reviewNo + ", content=" + content + ", createtime=" + createtime
				+ ", attractionNo=" + attractionNo + ", userNo=" + userNo + ", nickname=" + nickname + "]";
	}
	
	
}
