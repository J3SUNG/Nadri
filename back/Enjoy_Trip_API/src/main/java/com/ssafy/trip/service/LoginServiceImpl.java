package com.ssafy.trip.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.trip.model.dto.UserDto;
import com.ssafy.trip.model.mapper.LoginMapper;

@Service
public class LoginServiceImpl implements LoginService {
	
	LoginMapper loginMapper;
	
	@Autowired
	public LoginServiceImpl(LoginMapper loginMapper) {
		super();
		this.loginMapper = loginMapper;
	}

	@Override
	public UserDto login(Map<String, String> map) throws Exception {
		return loginMapper.login(map);
	}
}
