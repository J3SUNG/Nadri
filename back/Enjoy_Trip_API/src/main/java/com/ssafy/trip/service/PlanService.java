package com.ssafy.trip.service;

import java.util.List;

import com.ssafy.trip.model.dto.PlanDto;

public interface PlanService {

	PlanDto get(int planNo);

	void write(PlanDto planDto);

	void modify(PlanDto planDto);

	void delete(int planNo);

	List<PlanDto> list();

}
