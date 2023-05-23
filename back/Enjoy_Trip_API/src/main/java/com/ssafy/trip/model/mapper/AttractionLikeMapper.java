package com.ssafy.trip.model.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.model.dto.AttractionDto;

@Mapper
public interface AttractionLikeMapper {

	int get(HashMap<String, Integer> map);

	void create(HashMap<String, Integer> map);

	void delete(HashMap<String, Integer> map);

	void log(int i);

	List<AttractionDto> daily();

	List<AttractionDto> weekly();

	List<AttractionDto> monthly();

}
