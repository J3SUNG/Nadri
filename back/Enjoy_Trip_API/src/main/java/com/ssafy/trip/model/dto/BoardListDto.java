package com.ssafy.trip.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardListDto {
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
	private String saveFolder;
	private String originalFile;
	private String saveFile;
}
