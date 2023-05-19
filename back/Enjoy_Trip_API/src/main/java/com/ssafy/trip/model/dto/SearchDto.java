package com.ssafy.trip.model.dto;

import java.util.Arrays;

public class SearchDto {
	private String areaCode;
	private String sigunguCode;
	private int[] types;
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
	public int[] getTypes() {
		return types;
	}
	public void setTypes(int[] types) {
		this.types = types;
	}
	@Override
	public String toString() {
		return "SearchDto [areaCode=" + areaCode + ", sigunguCode=" + sigunguCode + ", types=" + Arrays.toString(types)
				+ "]";
	}
}
