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

import com.ssafy.trip.model.dto.PlanDto;
import com.ssafy.trip.service.PlanService;


@RestController
@RequestMapping("plan")
public class PlanController {
	private final Logger logger = LoggerFactory.getLogger(PlanController.class);
	PlanService planService;
	public PlanController(PlanService planService) {
		super();
		this.planService = planService;
	}
	
	@GetMapping("/{planNo}")
	public PlanDto get(@PathVariable("planNo") int planNo) throws Exception {
		logger.debug("get planNo : {}", planNo);
		PlanDto PlanDto = planService.get(planNo);
		return PlanDto;
	}
	
	@GetMapping("/list")
	public List<PlanDto> list() throws Exception {
		logger.debug("get all list of plan");
		List<PlanDto> list = planService.list();
		return list;
	}
	
	@PostMapping
	public String write(PlanDto PlanDto) throws Exception {
		logger.debug("write PlanNo : {}",PlanDto.getPlanNo());
		planService.write(PlanDto);
		return "success";
	}

	@PutMapping
	public PlanDto modify(PlanDto PlanDto) throws Exception {
		logger.debug("modify PlanDto : {}", PlanDto);
		planService.modify(PlanDto);
		return PlanDto;
	}

	@DeleteMapping("/{planNo}")
	public String delete(@PathVariable("planNo") int planNo) throws Exception {
		logger.debug("delete PlanDto : {}", planNo);
		planService.delete(planNo);
		return "success";
	}
}
