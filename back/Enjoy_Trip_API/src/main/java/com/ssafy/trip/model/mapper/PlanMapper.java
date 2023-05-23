package com.ssafy.trip.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.model.dto.PlanDto;

@Mapper
public interface PlanMapper {

	PlanDto get(Map<String, Integer> map);

	void write(PlanDto planDto);

	void modify(PlanDto planDto);

	void delete(int planNo);

	List<PlanDto> list(int userNo);

	void updateHit(int planNo);

	void fileRegister(PlanDto planDto);

	List<PlanDto> likelist(int userNo);

	List<PlanDto> writelist(int userNo);

	void visitLog(Map<String, Integer> map);

}
