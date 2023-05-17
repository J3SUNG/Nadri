package com.ssafy.trip.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.ssafy.trip.model.mapper.AttractionLikeMapper;

@Service
public class AttractionLikeServiceImpl implements AttractionLikeService {
	AttractionLikeMapper attractionLikeMapper;

	public AttractionLikeServiceImpl(AttractionLikeMapper attractionLikeMapper) {
		super();
		this.attractionLikeMapper = attractionLikeMapper;
	}

	@Override
	public int get(HashMap<String, Integer> map) {
		return attractionLikeMapper.get(map);
	}

	@Override
	public void create(HashMap<String, Integer> map) {
		attractionLikeMapper.create(map);
	}

	@Override
	public void delete(HashMap<String, Integer> map) {
		attractionLikeMapper.delete(map);
	}

}
