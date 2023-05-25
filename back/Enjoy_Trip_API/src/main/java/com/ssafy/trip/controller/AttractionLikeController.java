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

import com.ssafy.trip.model.dto.AttractionDto;
import com.ssafy.trip.model.dto.LogDto;
import com.ssafy.trip.service.AttractionLikeService;

@RestController
@RequestMapping("/attractionlike")
public class AttractionLikeController {
	private final Logger logger = LoggerFactory.getLogger(AttractionLikeController.class);
	AttractionLikeService attractionLikeService;

	public AttractionLikeController(AttractionLikeService attractionLikeService) {
		super();
		this.attractionLikeService = attractionLikeService;
	}

	@GetMapping("/{attrNo}/{userNo}")
	public int get(@PathVariable("attrNo") int attrNo, @PathVariable("userNo") int userNo) throws Exception {
		logger.debug("like board {} user {}", attrNo, userNo);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("attrNo", attrNo);
		map.put("userNo", userNo);

		int result = attractionLikeService.get(map);
		return result;
	}

	@PostMapping("/{attrNo}/{userNo}")
	public String create(@PathVariable("attrNo") int attrNo, @PathVariable("userNo") int userNo) throws Exception {
		logger.debug("like board number of : {}", attrNo);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("attrNo", attrNo);
		map.put("userNo", userNo);
		attractionLikeService.create(map);
		return "success";
	}

	@DeleteMapping("/{attrNo}/{userNo}")
	public String delete(@PathVariable("attrNo") int attrNo, @PathVariable("userNo") int userNo) throws Exception {
		logger.debug("unlike board number of : {}", attrNo);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("attrNo", attrNo);
		map.put("userNo", userNo);
		attractionLikeService.delete(map);
		return "success";
	}

	@GetMapping("/daily")
	public List<AttractionDto> dailyTop10() {
		logger.debug("daily top 10");
		return attractionLikeService.dailyTop10();
	}

	@GetMapping("/weekly")
	public List<AttractionDto> weeklyTop10() {
		logger.debug("weekly top 10");
		return attractionLikeService.weeklyTop10();
	}

	@GetMapping("/monthly")
	public List<AttractionDto> monthlyTop10() {
		logger.debug("monthly top 10");
		return attractionLikeService.monthlyTop10();
	}

	@GetMapping("/sido")
	public List<AttractionDto> sidoTop10() {
		logger.debug("sido top 10");
		return attractionLikeService.sidoTop10();
	}

	@GetMapping("/day/{date}")
	public List<LogDto> dayTop5(@PathVariable String date) {
		logger.debug("day top 10");
		return attractionLikeService.day(date);
	}
}
