package com.ssafy.trip.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.model.dto.BoardDto;
import com.ssafy.trip.model.dto.BoardListDto;
import com.ssafy.trip.model.dto.FileInfoDto;

@Mapper
public interface BoardMapper {

	List<BoardListDto> listArticle(Map<String, Object> param) throws SQLException;

	void writeArticle(BoardDto boardDto) throws SQLException;

	BoardDto getArticle(Map<String, Integer> map) throws SQLException;

	int getTotalArticleCount(Map<String, Object> param) throws SQLException;

	void modifyArticle(BoardDto boardDto) throws SQLException;

	void deleteArticle(int articleNo) throws SQLException;

	void fileRegister(BoardDto boardDto);

	List<FileInfoDto> fileInfoList(int boardNo);
}
