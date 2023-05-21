package com.ssafy.trip.service;

import java.util.List;

import com.ssafy.trip.model.dto.PlanDto;

public interface PlanService {

	PlanDto get(int planNo, int userNo);

	void write(PlanDto planDto);

	void modify(PlanDto planDto);

	void delete(int planNo);

	List<PlanDto> list(int userNo);

	void updateHit(int planNo);

	List<PlanDto> likelist(int userNo);

}
