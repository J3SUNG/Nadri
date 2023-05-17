package com.ssafy.trip.service;

import java.util.List;

import com.ssafy.trip.model.dto.BoardDto;
import com.ssafy.trip.model.dto.BoardParameterDto;

public interface BoardService {
	
	List<BoardDto> listArticle(BoardParameterDto boardParameterDto) throws Exception;
	void writeArticle(BoardDto boardDto) throws Exception;
//	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
	BoardDto getArticle(int boardNo) throws Exception;

	void modifyArticle(BoardDto boardDto) throws Exception;
	void deleteArticle(int articleNo) throws Exception;
	
}
