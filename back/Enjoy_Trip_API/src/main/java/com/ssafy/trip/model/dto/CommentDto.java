package com.ssafy.trip.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
	private int commentNo;
	private String content;
	private String createTime;
	private int userNo;
	private int boardNo;
	private String nickname;
	private String imgSaveFolder;
	private String imgSaveFile;
}
