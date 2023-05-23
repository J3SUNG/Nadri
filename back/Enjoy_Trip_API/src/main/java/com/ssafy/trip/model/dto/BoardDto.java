package com.ssafy.trip.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
	private int boardNo;
	private int boardType;
	private String createTime;
	private String subject;
	private String content;
	private int likeCount;
	private int userNo;
	private String nickname;
	private int commentCount;
	private int isLike;
	private List<String> url;
	private List<FileInfoDto> fileInfos;
	private String imgSaveFolder;
	private String imgSaveFile;
	private String saveFolder;
	private String saveFile;
	
}
