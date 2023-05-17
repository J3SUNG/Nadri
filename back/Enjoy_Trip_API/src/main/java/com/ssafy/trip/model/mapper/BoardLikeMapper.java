package com.ssafy.trip.model.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface BoardLikeMapper {

	int get(HashMap<String, Integer> map);

	void create(HashMap<String, Integer> map);

	void delete(HashMap<String, Integer> map);

}
