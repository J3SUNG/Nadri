package com.ssafy.trip.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.model.dto.UserDto;

@Mapper
public interface LoginMapper {
	UserDto login(Map<String, String> map) throws SQLException;
}
