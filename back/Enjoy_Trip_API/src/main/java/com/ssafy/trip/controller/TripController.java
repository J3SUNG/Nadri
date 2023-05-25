package com.ssafy.trip.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.trip.model.dto.TripDto;
import com.ssafy.trip.service.TripService;

@RestController
@RequestMapping("trip")
public class TripController {
	private final Logger logger = LoggerFactory.getLogger(PlanController.class);
	TripService tripService;

	public TripController(TripService tripService) {
		super();
		this.tripService = tripService;
	}

	@GetMapping("/{tripNo}")
	public TripDto get(@PathVariable("tripNo") int tripNo) throws Exception {
		logger.debug("get TripNo : {}", tripNo);
		TripDto tripDto = tripService.get(tripNo);
		return tripDto;
	}

	@GetMapping("/list/{planNo}")
	public List<TripDto> list(@PathVariable("planNo") int planNo) throws Exception {
		logger.debug("list PlanNo : {}", planNo);
		List<TripDto> list = tripService.list(planNo);
		return list;
	}

	@PostMapping
	public String write(TripDto tripDto) throws Exception {
		logger.debug("write PlanNo : {}", tripDto.getPlanNo());
		tripService.write(tripDto);
		return "success";
	}

	@PutMapping
	public TripDto modify(TripDto tripDto) throws Exception {
		logger.debug("modify TripDto : {}", tripDto);
		tripService.modify(tripDto);
		return tripDto;
	}

	@DeleteMapping("/{tripNo}")
	public String delete(@PathVariable("tripNo") int tripNo) throws Exception {
		logger.debug("delete TripDto : {}", tripNo);
		tripService.delete(tripNo);
		return "success";
	}
}
