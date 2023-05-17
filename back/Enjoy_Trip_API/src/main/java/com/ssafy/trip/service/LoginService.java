package com.ssafy.trip.service;

import java.util.Map;

import com.ssafy.trip.model.dto.UserDto;

public interface LoginService {
	UserDto login(Map<String, String> map) throws Exception;
}
