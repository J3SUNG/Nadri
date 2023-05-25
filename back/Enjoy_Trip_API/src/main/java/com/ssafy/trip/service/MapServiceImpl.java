package com.ssafy.trip.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.trip.model.dto.AttractionDto;
import com.ssafy.trip.model.dto.SearchDto;
import com.ssafy.trip.model.mapper.AttractionLikeMapper;
import com.ssafy.trip.model.mapper.MapMapper;

@Service
public class MapServiceImpl implements MapService {

	private MapMapper mapMapper;

	public MapServiceImpl(MapMapper mapMapper) {
		super();
		this.mapMapper = mapMapper;
	}
	
	@Autowired
	private AttractionLikeMapper attMapper;

	@Override
	public List<AttractionDto> search(SearchDto searchDto) throws Exception {
		return mapMapper.search(searchDto);
	}

	@Override
	public AttractionDto getAttr(Map<String, Integer> map) {
		attMapper.create(map);
		return mapMapper.getAttr(map.get("attrNo"));
	}

	@Override
	public List<AttractionDto> watch(int userNo) {
		return mapMapper.watch(userNo);
	}

}
