package com.ssafy.trip.model.dto;

public class PlanDto {
	private int planNo;
	private String createTime;
	private String title;
	private String content;
	private String startDate;
	private String endDate;
	private int readCount;
	private int userNo;

	public int getPlanNo() {
		return planNo;
	}

	public void setPlanNo(int planNo) {
		this.planNo = planNo;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	@Override
	public String toString() {
		return "PlanDto [planNo=" + planNo + ", createTime=" + createTime + ", title=" + title + ", content=" + content
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", readCount=" + readCount + ", userNo="
				+ userNo + "]";
	}
}
