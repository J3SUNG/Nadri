package com.ssafy.trip.service;

import java.util.List;
import java.util.Map;

import com.ssafy.trip.model.dto.PlanDto;
import com.ssafy.trip.model.dto.UserDto;


public interface UserService {
	void joinUser(UserDto userDto) throws Exception;	
	void deleteUser(String id) throws Exception;
	void modifyUser(UserDto userDto) throws Exception;
//	UserDto getUser(String id) throws Exception;
	int check(Map<String, String> map) throws Exception;
	boolean authEmail(Map<String, String> map);
	List<PlanDto> getLikePlan(int userNo);
}
