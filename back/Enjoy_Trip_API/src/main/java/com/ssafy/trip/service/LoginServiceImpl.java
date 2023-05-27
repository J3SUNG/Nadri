package com.ssafy.trip.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ssafy.trip.model.dto.FileInfoDto;
import com.ssafy.trip.model.dto.UserDto;
import com.ssafy.trip.model.mapper.LoginMapper;
import com.ssafy.trip.model.mapper.UserMapper;
import com.ssafy.trip.util.HashAlgorithm;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	UserMapper userMapper;
	
	@Value("${file.url}")
	private String serverUrl;
	
	@Value("${file.imgPath}")
	private String uploadPath;
	
	
	
	String SALT = "HelloSsafy";

	@Override
	public UserDto login(UserDto userDto) throws Exception {
		if (userDto.getId() == null || userDto.getPassword() == null)
			return null;
		//비밀번호를 해시값으로 변경
		byte[] pass = userDto.getPassword().getBytes();
		String hashedpass = HashAlgorithm.Hashing(pass, SALT);
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", userDto.getId());
		map.put("password", hashedpass);
		return loginMapper.login(map);
	}

	@Override
	public UserDto userInfo(String userid) throws Exception {
		UserDto user = loginMapper.userInfo(userid);
		FileInfoDto file = userMapper.getFile(user.getUserNo());
		user.setFile(file);
		if(file == null) {
			file = userMapper.getFile(1);
		}
		StringBuilder sb = new StringBuilder();
		
		sb.append(serverUrl);
//		sb.append("http://59.151.232.152");
		sb.append(":7777/image/showImage?saveFolder=");
		//"http://192.168.31.78:7777/image/showImage?saveFolder=230523&saveFile=6d0bd9e3-e8c1-4c22-a59f-e3aad226c281.jpg"
		sb.append(file.getSaveFolder());
		sb.append("&saveFile=");
		sb.append(file.getSaveFile());
		user.setUrl(sb.toString());
		return user;
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
