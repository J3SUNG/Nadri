package com.ssafy.trip.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripDto {
	private int tripNo;
	private int order;
	private String memo;
	private int planNo;
	private int attractionNo;
}
