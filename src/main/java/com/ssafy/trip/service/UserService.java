package com.ssafy.trip.service;

import com.ssafy.trip.model.dto.UserDto;


public interface UserService {
	int idCheck(String id) throws Exception;
	void joinUser(UserDto userDto) throws Exception;	
	void deleteUser(String id) throws Exception;
	void modifyUser(UserDto userDto) throws Exception;
	UserDto getUser(String id) throws Exception;
}
