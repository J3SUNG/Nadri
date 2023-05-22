package com.ssafy.trip.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchDto {
	private String areaCode;
	private String sigunguCode;
	private String search;
	private String[] contentType;
}
