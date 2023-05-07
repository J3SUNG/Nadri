package com.ssafy.trip.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.model.dto.CommentDto;

@Mapper
public interface CommentMapper {

	List<CommentDto> list(int boardNo);

	void write(CommentDto commentDto);

	void modify(CommentDto commentDto);

	void delete(int commentNo);

}
