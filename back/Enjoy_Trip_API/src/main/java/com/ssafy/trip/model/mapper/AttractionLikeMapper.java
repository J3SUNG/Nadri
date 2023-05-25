package com.ssafy.trip.model.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.model.dto.AttractionDto;
import com.ssafy.trip.model.dto.LogDto;

@Mapper
public interface AttractionLikeMapper {

	int get(HashMap<String, Integer> map);

	void create(Map<String, Integer> map);

	void delete(HashMap<String, Integer> map);

	void log(int i);

	List<AttractionDto> daily();

	List<AttractionDto> weekly();

	List<AttractionDto> monthly();

	List<AttractionDto> sido();

	List<LogDto> day(String date);

}
