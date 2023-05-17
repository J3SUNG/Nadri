package com.ssafy.trip.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.trip.model.dto.AttractionDto;
import com.ssafy.trip.model.dto.SearchDto;
import com.ssafy.trip.model.mapper.MapMapper;

@Service
public class MapServiceImpl implements MapService {

	private MapMapper mapMapper;

	public MapServiceImpl(MapMapper mapMapper) {
		super();
		this.mapMapper = mapMapper;
	}

	@Override
	public List<AttractionDto> search(SearchDto searchDto) throws Exception {
		return mapMapper.search(searchDto);
	}

	@Override
	public AttractionDto getAttr(Map<String, Object> map) {
		mapMapper.visitLog(map);
		return mapMapper.getAttr((String) map.get("attrNo"));
	}

}
