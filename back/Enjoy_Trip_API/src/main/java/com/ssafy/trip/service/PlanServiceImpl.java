package com.ssafy.trip.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.trip.model.dto.PlanDto;
import com.ssafy.trip.model.mapper.PlanMapper;

@Service
public class PlanServiceImpl implements PlanService {
	PlanMapper planMapper;
	public PlanServiceImpl(PlanMapper planMapper) {
		super();
		this.planMapper = planMapper;
	}

	@Override
	public PlanDto get(int planNo,int userNo) {
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("planNo", planNo);
		map.put("userNo", userNo);
		planMapper.visitLog(map);
		return planMapper.get(map);
	}

	@Override
	public void write(PlanDto planDto) {
		planMapper.write(planDto);
		System.out.println(planDto.getPlanNo());
	}

	@Override
	public void modify(PlanDto planDto) {
		planMapper.modify(planDto);
	}

	@Override
	public void delete(int planNo) {
		planMapper.delete(planNo);
	}

	@Override
	public List<PlanDto> list(int userNo) {
		return planMapper.list(userNo);
	}

	@Override
	public void updateHit(int planNo) {
		planMapper.updateHit(planNo);
	}

	@Override
	public List<PlanDto> likelist(int userNo) {
		return planMapper.likelist(userNo);
	}

	@Override
	public List<PlanDto> writelist(int userNo) {
		return planMapper.writelist(userNo);
	}

	@Override
	public List<PlanDto> mylikelist(int userNo) {
		return planMapper.mylikelist(userNo);
	}

	@Override
	public List<PlanDto> watch(int userNo) {
		return planMapper.watch(userNo);
	}

}
