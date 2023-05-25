package com.ssafy.trip.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.trip.model.dto.BoardLikeDto;
import com.ssafy.trip.service.BoardLikeService;

@RestController
@RequestMapping("/boardlike")
public class BoardLikeController {
	private final Logger logger = LoggerFactory.getLogger(BoardLikeController.class);
	BoardLikeService boardLikeService;

	public BoardLikeController(BoardLikeService boardLikeService) {
		super();
		this.boardLikeService = boardLikeService;
	}

	@GetMapping("/{boardNo}")
	public int get(@PathVariable("boardNo") int boardNo, @PathVariable("userNo") int userNo) throws Exception {
		logger.debug("like board {} user {}", boardNo, userNo);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("boardNo", boardNo);
		map.put("userNo", userNo);

		int result = boardLikeService.get(map);
		return result;
	}

	@PostMapping("/{boardNo}/{userNo}")
	public String create(@PathVariable("boardNo") int boardNo, @PathVariable("userNo") int userNo) throws Exception {
		logger.debug("like board number of : {}", boardNo);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("boardNo", boardNo);
		map.put("userNo", userNo);
		boardLikeService.create(map);
		return "success";
	}

	@DeleteMapping("/{boardNo}/{userNo}")
	public String delete(@PathVariable("boardNo") int boardNo, @PathVariable("userNo") int userNo) throws Exception {
		logger.debug("unlike board number of : {}", boardNo);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("boardNo", boardNo);
		map.put("userNo", userNo);
		boardLikeService.delete(map);
		return "success";
	}
}
