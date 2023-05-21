package com.ssafy.trip.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.trip.model.dto.UserDto;
import com.ssafy.trip.model.mapper.LoginMapper;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginMapper loginMapper;

	@Override
	public UserDto login(UserDto userDto) throws Exception {
		if (userDto.getId() == null || userDto.getPassword() == null)
			return null;
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", userDto.getId());
		map.put("password", userDto.getPassword());
		System.out.println(map.get("id"));
		return loginMapper.login(map);
	}

	@Override
	public UserDto userInfo(String userid) throws Exception {
		return loginMapper.userInfo(userid);
	}
	
	@Override
	public void saveRefreshToken(String userid, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", "user1");
		map.put("token", refreshToken);
		loginMapper.saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(String userid) throws Exception {
		return loginMapper.getRefreshToken(userid);
	}

	@Override
	public void deleRefreshToken(String userid) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("token", null);
		loginMapper.deleteRefreshToken(map);
	}
}
