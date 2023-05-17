package com.ssafy.trip.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.model.dto.PlanDto;

@Mapper
public interface PlanMapper {

	PlanDto get(int planNo);

	void write(PlanDto planDto);

	void modify(PlanDto planDto);

	void delete(int planNo);

	List<PlanDto> list();

}
