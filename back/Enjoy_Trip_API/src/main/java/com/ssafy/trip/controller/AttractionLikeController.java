package com.ssafy.trip.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping("/{attrNo}")
	public int get(@PathVariable("attrNo") int attrNo) throws Exception {
		/**
		 * 세션??에서 사용자 번호를 가져와서 사용자가 attrNo에 해당하는 게시글에 좋아요를 눌렀다면 1 아니면 0 반환
		 */
		int userNo = 1;//test
		logger.debug("like board {} user {}", attrNo,userNo);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("attrNo", attrNo);
		map.put("userNo", userNo);

		int result = attractionLikeService.get(map);
		return result;
	}
	
	@PostMapping("/{attrNo}")
	public String create(@PathVariable("attrNo") int attrNo) throws Exception {
		logger.debug("like board number of : {}", attrNo);
		int userNo = 1;//test
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("attrNo", attrNo);
		map.put("userNo", userNo);
		attractionLikeService.create(map);
		return "success";
	}
	
	@DeleteMapping("/{attrNo}")
	public String delete(@PathVariable("attrNo") int attrNo) throws Exception {
		logger.debug("unlike board number of : {}", attrNo);
		int userNo = 1;//test
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("attrNo", attrNo);
		map.put("userNo", userNo);
		attractionLikeService.delete(map);
		return "success";
	}
	
}
