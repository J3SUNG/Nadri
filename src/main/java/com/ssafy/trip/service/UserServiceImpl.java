package com.ssafy.trip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.trip.model.dto.UserDto;
import com.ssafy.trip.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	private UserMapper userMapper;

	@Autowired
	public UserServiceImpl(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}

	@Override
	public UserDto getUser(String id) throws Exception {
		return userMapper.getUser(id);
	}
	
	@Override
	public void joinUser(UserDto userDto) throws Exception {
		userMapper.joinUser(userDto);
	}	

	@Override
	public void deleteUser(String id) throws Exception {
		userMapper.deleteUser(id);
	}

	@Override
	public void modifyUser(UserDto userDto) throws Exception {
		userMapper.modifyUser(userDto);
	}

	@Override
	public int idCheck(String id) throws Exception {
		return userMapper.idCheck(id);
	}
}
