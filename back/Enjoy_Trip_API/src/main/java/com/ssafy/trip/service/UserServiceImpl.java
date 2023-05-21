package com.ssafy.trip.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.trip.model.dto.FileInfoDto;
import com.ssafy.trip.model.dto.PlanDto;
import com.ssafy.trip.model.dto.UserDto;
import com.ssafy.trip.model.mapper.UserMapper;

import lombok.extern.log4j.Log4j;

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
		UserDto user = userMapper.getUser(id);
		FileInfoDto file = userMapper.getFile(user.getUserNo());
		user.setFile(file);
		return user;
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
		System.out.println(userDto.getUserNo());
		userMapper.fileRegister(userDto);
	}

	@Override
	public int check(Map<String, String> map) throws Exception {
		return userMapper.check(map);
	}

	@Override
	public boolean authEmail(Map<String, String> map) {
		int count = userMapper.authEmail(map);
		return count==1?true:false;
	}

	@Override
	public List<PlanDto> getLikePlan(int userNo) {
		return userMapper.getLikePlan(userNo);
	}
}
