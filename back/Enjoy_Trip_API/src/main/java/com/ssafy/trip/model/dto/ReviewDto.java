package com.ssafy.trip.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
	private String reviewNo;
	private String content;
	private String createtime;
	private int attractionNo;
	private int userNo;
	private String nickname;
}
