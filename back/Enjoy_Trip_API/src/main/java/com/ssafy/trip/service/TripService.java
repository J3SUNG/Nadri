package com.ssafy.trip.service;

import java.util.List;

import com.ssafy.trip.model.dto.PlanDto;
import com.ssafy.trip.model.dto.ReviewDto;
import com.ssafy.trip.model.dto.TripDto;

public interface TripService {

	TripDto get(int tripNo);

	List<TripDto> list(int planNo);

	void write(TripDto tripDto);

	void modify(TripDto tripDto);

	void delete(int tripDto);

	void write(TripDto tripDto, int planNo);

}
