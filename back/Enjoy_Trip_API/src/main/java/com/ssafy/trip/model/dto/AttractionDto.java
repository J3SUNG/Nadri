package com.ssafy.trip.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttractionDto {
	private int attractionNo;
	private String title;
	private String addr1;
	private String addr2;
	private String zipcode;
	private String tel;
	private int contentType;
	private String image1;
	private String image2;
	private double latitude;
	private double longitude;
	private String overview;
	private int sidoCode;
	private int gugunCode;
}
