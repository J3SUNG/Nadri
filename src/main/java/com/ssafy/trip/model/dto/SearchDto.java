package com.ssafy.trip.model.dto;

public class SearchDto {
	private String areaCode;
	private String sigunguCode;
	private String contentTypeId;
	public SearchDto(String areaCode, String sigunguCode, String contentTypeId) {
		super();
		this.areaCode = areaCode;
		this.sigunguCode = sigunguCode;
		this.contentTypeId = contentTypeId;
	}
	
	
	public String getAreaCode() {
		return areaCode;
	}


	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}


	public String getSigunguCode() {
		return sigunguCode;
	}


	public void setSigunguCode(String sigunguCode) {
		this.sigunguCode = sigunguCode;
	}


	public String getContentTypeId() {
		return contentTypeId;
	}


	public void setContentTypeId(String contentTypeId) {
		this.contentTypeId = contentTypeId;
	}


	@Override
	public String toString() {
		return "SearchDto [areaCode=" + areaCode + ", sigunguCode=" + sigunguCode + ", contentTypeId=" + contentTypeId
				+ "]";
	}
}
