package com.ssafy.trip.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.model.dto.UserDto;

@Mapper
public interface LoginMapper {
	public UserDto login(Map<String, String> map) throws SQLException;

	public UserDto userInfo(String userid) throws SQLException;

	public void saveRefreshToken(Map<String, String> map) throws SQLException;

	public Object getRefreshToken(String userid) throws SQLException;

	public void deleteRefreshToken(Map<String, String> map) throws SQLException;
}
