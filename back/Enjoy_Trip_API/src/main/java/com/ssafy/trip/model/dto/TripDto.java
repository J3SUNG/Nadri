package com.ssafy.trip.model.dto;

public class TripDto {
	private int tripNo;
	private int order;
	private String memo;
	private int planNo;
	private int attractionNo;
	
	public int getTripNo() {
		return tripNo;
	}

	public void setTripNo(int tripNo) {
		this.tripNo = tripNo;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getPlanNo() {
		return planNo;
	}

	public void setPlanNo(int planNo) {
		this.planNo = planNo;
	}

	public int getAttractionNo() {
		return attractionNo;
	}

	public void setAttractionNo(int attractionNo) {
		this.attractionNo = attractionNo;
	}

	@Override
	public String toString() {
		return "TripDto [tripNo=" + tripNo + ", order=" + order + ", memo=" + memo + ", planNo=" + planNo
				+ ", attractionNo=" + attractionNo + "]";
	}
}
