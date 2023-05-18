package com.ssafy.trip.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.ssafy.trip.model.mapper.PlanLikeMapper;

@Service
public class PlanLikeServiceImpl implements PlanLikeService {
	PlanLikeMapper planLikeMapper;
	public PlanLikeServiceImpl(PlanLikeMapper planLikeMapper) {
		super();
		this.planLikeMapper = planLikeMapper;
	}

	@Override
	public int get(HashMap<String, Integer> map) {
		return planLikeMapper.get(map);
	}

	@Override
	public void create(HashMap<String, Integer> map) {
		planLikeMapper.create(map);
	}

	@Override
	public void delete(HashMap<String, Integer> map) {
		planLikeMapper.delete(map);
	}

}
