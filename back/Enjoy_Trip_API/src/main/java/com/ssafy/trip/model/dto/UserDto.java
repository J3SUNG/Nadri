package com.ssafy.trip.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {	
	private int userNo;
	private String id;
	private String password;
	private String nickname;
	private String email;
	private String joinDate;
	private String grade;
	private FileInfoDto file;
	private String url;
	private String saveFolder;
	private String saveFile;
}
