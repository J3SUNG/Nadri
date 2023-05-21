package com.ssafy.trip.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanDto {
	private int planNo;
	private String createTime;
	private String subject;
	private String content;
	private String startDate;
	private String endDate;
	private int readCount;
	private int userNo;
	private String nickname;
	private int isLike;
	private int likeCount;
	private List<TripDto> trips;
	private String image1;
//	private List<FileInfoDto> fileInfos;
}
