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

import com.ssafy.trip.service.PlanLikeService;

@RestController
@RequestMapping("/planlike")
public class PlanLikeController {
	private final Logger logger = LoggerFactory.getLogger(BoardLikeController.class);
	PlanLikeService planLikeService;

	public PlanLikeController(PlanLikeService planLikeService) {
		super();
		this.planLikeService = planLikeService;
	}

	@GetMapping("/{planNo}/{userNo}")
	public int get(@PathVariable("planNo") int planNo, @PathVariable("userNo") int userNo) throws Exception {
		logger.debug("like plan {} user {}", planNo, userNo);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("planNo", planNo);
		map.put("userNo", userNo);

		int result = planLikeService.get(map);
		return result;
	}

	@PostMapping("/{planNo}/{userNo}")
	public String create(@PathVariable("planNo") int planNo, @PathVariable("userNo") int userNo) throws Exception {
		logger.debug("like plan number of : {}", planNo);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("planNo", planNo);
		map.put("userNo", userNo);
		planLikeService.create(map);
		return "success";
	}

	@DeleteMapping("/{planNo}/{userNo}")
	public String delete(@PathVariable("planNo") int planNo, @PathVariable("userNo") int userNo) throws Exception {
		logger.debug("unlike plan number of : {}", planNo);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("planNo", planNo);
		map.put("userNo", userNo);
		planLikeService.delete(map);
		return "success";
	}
}
