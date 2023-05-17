package com.ssafy.trip.service;

import java.util.List;

import com.ssafy.trip.model.dto.CommentDto;

public interface CommentService {

	List<CommentDto> list(int boardNo);

	void write(CommentDto commentDto);

	void modify(CommentDto commentDto);

	void delete(int commentNo);

}
