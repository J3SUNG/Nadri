package com.ssafy.trip.service;

import java.util.HashMap;
import java.util.List;

import com.ssafy.trip.model.dto.BoardLikeDto;

public interface BoardLikeService {

	int get(HashMap<String, Integer> map);

	void create(HashMap<String, Integer> map);

	void delete(HashMap<String, Integer> map);
	
	List<BoardLikeDto> list(int userNo);

}
