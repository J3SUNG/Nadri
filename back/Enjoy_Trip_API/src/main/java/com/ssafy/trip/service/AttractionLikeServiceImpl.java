package com.ssafy.trip.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.trip.model.dto.AttractionDto;
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
//		int[] list = {125266,125850,125409,125502,126230,126017,126500,126228,125420,125713,125492,125452,125449,125406,125677,125416,126438,126001,125417,125505};
//		for(int i = 15;i<list.length;i++) {
//			attractionLikeMapper.log(list[i]);
//		}
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
}
