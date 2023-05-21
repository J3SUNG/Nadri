package com.ssafy.trip.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.model.dto.FileInfoDto;
import com.ssafy.trip.model.dto.PlanDto;
import com.ssafy.trip.model.dto.UserDto;

@Mapper
public interface UserMapper {
	void joinUser(UserDto userDto) throws SQLException;	
	void deleteUser(String id) throws SQLException;
	void modifyUser(UserDto userDto) throws SQLException;
	UserDto getUser(String id) throws SQLException;
	int check(Map<String, String> map);
	int authEmail(Map<String, String> map);
	void fileRegister(UserDto userDto);
	List<PlanDto> getLikePlan(int userNo);
	FileInfoDto getFile(int userNo);
}
