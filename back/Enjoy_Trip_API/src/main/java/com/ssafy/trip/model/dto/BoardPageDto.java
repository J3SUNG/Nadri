package com.ssafy.trip.model.dto;

import java.util.List;

import com.ssafy.trip.util.PageNavigation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardPageDto {
	private PageNavigation pageNavigation;
	List<BoardListDto> list;
}
