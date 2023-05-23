package com.ssafy.trip.service;

import java.util.HashMap;
import java.util.List;

import com.ssafy.trip.model.dto.AttractionDto;

public interface AttractionLikeService {

	int get(HashMap<String, Integer> map);

	void create(HashMap<String, Integer> map);

	void delete(HashMap<String, Integer> map);

	List<AttractionDto> dailyTop10();

	List<AttractionDto> weeklyTop10();

	List<AttractionDto> monthlyTop10();


}
