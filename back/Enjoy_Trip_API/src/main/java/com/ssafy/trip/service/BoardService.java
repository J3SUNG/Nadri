package com.ssafy.trip.service;

import java.util.List;

import com.ssafy.trip.model.dto.BoardDto;
import com.ssafy.trip.model.dto.BoardListDto;
import com.ssafy.trip.model.dto.BoardParameterDto;
import com.ssafy.trip.util.PageNavigation;

public interface BoardService {

	List<BoardListDto> listArticle(BoardParameterDto boardParameterDto) throws Exception;

	void writeArticle(BoardDto boardDto) throws Exception;

	BoardDto getArticle(int boardNo, int userNo) throws Exception;

	void modifyArticle(BoardDto boardDto) throws Exception;

	void deleteArticle(int articleNo) throws Exception;

	PageNavigation makePageNavigation(BoardParameterDto boardParameterDto) throws Exception;

}
