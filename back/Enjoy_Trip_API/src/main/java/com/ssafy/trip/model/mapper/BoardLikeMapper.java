package com.ssafy.trip.model.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.model.dto.BoardLikeDto;
@Mapper
public interface BoardLikeMapper {

	int get(HashMap<String, Integer> map);

	void create(HashMap<String, Integer> map);

	void delete(HashMap<String, Integer> map);

	List<BoardLikeDto> list(int userNo);

}
