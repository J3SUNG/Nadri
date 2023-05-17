package com.ssafy.trip.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.ssafy.trip.model.mapper.BoardLikeMapper;

@Service
public class BoardLikeServiceImpl implements BoardLikeService {
	BoardLikeMapper boardLikeMapper;
	public BoardLikeServiceImpl(BoardLikeMapper boardLikeMapper) {
		super();
		this.boardLikeMapper = boardLikeMapper;
	}

	@Override
	public int get(HashMap<String, Integer> map) {
		return boardLikeMapper.get(map);
	}

	@Override
	public void create(HashMap<String, Integer> map) {
		boardLikeMapper.create(map);
	}

	@Override
	public void delete(HashMap<String, Integer> map) {
		boardLikeMapper.delete(map);
	}

}
