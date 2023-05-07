package com.ssafy.trip.service;

import java.util.List;
import java.util.Map;

import com.ssafy.trip.model.dto.AttractionDto;
import com.ssafy.trip.model.dto.SearchDto;

public interface MapService {

	List<AttractionDto> search(SearchDto searchDto) throws Exception;

	AttractionDto getAttr(Map<String, Object> map);

}
