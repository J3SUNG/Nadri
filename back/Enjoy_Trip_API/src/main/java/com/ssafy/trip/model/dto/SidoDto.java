package com.ssafy.trip.model.dto;

public class SidoDto {
	private String sidoNo;
	private String sidoName;
	public String getSidoNo() {
		return sidoNo;
	}
	public void setSidoNo(String sidoNo) {
		this.sidoNo = sidoNo;
	}
	public String getSidoName() {
		return sidoName;
	}
	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}
	@Override
	public String toString() {
		return "SidoDto [sidoNo=" + sidoNo + ", sidoName=" + sidoName + "]";
	}
	
	
}
