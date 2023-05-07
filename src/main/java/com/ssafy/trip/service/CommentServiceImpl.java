package com.ssafy.trip.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.trip.model.dto.CommentDto;
import com.ssafy.trip.model.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService {
	CommentMapper commentMapper;
	public CommentServiceImpl(CommentMapper commentMapper) {
		super();
		this.commentMapper = commentMapper;
	}

	@Override
	public List<CommentDto> list(int boardNo) {
		return commentMapper.list(boardNo);
	}

	@Override
	public void write(CommentDto commentDto) {
		commentMapper.write(commentDto);
	}

	@Override
	public void modify(CommentDto commentDto) {
		commentMapper.modify(commentDto);
	}

	@Override
	public void delete(int commentNo) {
		commentMapper.delete(commentNo);
	}

}
