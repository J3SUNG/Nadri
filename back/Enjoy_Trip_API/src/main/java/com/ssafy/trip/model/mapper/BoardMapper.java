package com.ssafy.trip.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.model.dto.BoardDto;

@Mapper
public interface BoardMapper {

	List<BoardDto> listArticle(Map<String, Object> param) throws SQLException;

	void writeArticle(BoardDto boardDto) throws SQLException;

	BoardDto getArticle(int articleNo) throws SQLException;

//	int getTotalArticleCount(Map<String, Object> param) throws SQLException;
//	void updateHit(int articleNo) throws SQLException;

	void modifyArticle(BoardDto boardDto) throws SQLException;

	void deleteArticle(int articleNo) throws SQLException;
}
