package com.ssafy.trip.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.trip.model.dto.AttractionDto;
import com.ssafy.trip.model.dto.LogDto;
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

	@Override
	public List<AttractionDto> dailyTop10() {
		return attractionLikeMapper.daily();
	}

	@Override
	public List<AttractionDto> weeklyTop10() {
		return attractionLikeMapper.weekly();
	}

	@Override
	public List<AttractionDto> monthlyTop10() {
		return attractionLikeMapper.monthly();
	}

	@Override
	public List<AttractionDto> sidoTop10() {
		return attractionLikeMapper.sido();
	}

	@Override
	public List<LogDto> day(String date) {
		return attractionLikeMapper.day(date);
	}
}
