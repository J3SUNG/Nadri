package com.ssafy.trip.model.dto;

public class GugunDto {
	private String gugunNo;
	private String gugunName;
	private String sidoNo;
	public String getGugunNo() {
		return gugunNo;
	}
	public void setGugunNo(String gugunNo) {
		this.gugunNo = gugunNo;
	}
	public String getGugunName() {
		return gugunName;
	}
	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}
	public String getSidoNo() {
		return sidoNo;
	}
	public void setSidoNo(String sidoNo) {
		this.sidoNo = sidoNo;
	}
	@Override
	public String toString() {
		return "GugunDto [gugunNo=" + gugunNo + ", gugunName=" + gugunName + ", sidoNo=" + sidoNo + "]";
	}
	
	
}
