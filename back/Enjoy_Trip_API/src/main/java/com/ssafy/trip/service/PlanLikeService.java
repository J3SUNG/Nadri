package com.ssafy.trip.service;

import java.util.HashMap;

public interface PlanLikeService {

	int get(HashMap<String, Integer> map);

	void create(HashMap<String, Integer> map);

	void delete(HashMap<String, Integer> map);

}
