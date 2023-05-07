package com.ssafy.trip.service;

import java.util.List;
import java.util.Map;

import com.ssafy.trip.model.dto.BoardDto;
import com.ssafy.trip.util.PageNavigation;

public interface BoardService {
	
	List<BoardDto> listArticle(Map<String, String> map) throws Exception;
	void writeArticle(BoardDto boardDto) throws Exception;
//	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
	BoardDto getArticle(int boardNo) throws Exception;

	void modifyArticle(BoardDto boardDto) throws Exception;
	void deleteArticle(int articleNo) throws Exception;
	
}
