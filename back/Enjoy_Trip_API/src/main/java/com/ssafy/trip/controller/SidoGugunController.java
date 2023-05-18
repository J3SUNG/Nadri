package com.ssafy.trip.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.trip.model.dto.GugunDto;
import com.ssafy.trip.model.dto.SidoDto;
import com.ssafy.trip.service.SidoGugunService;

@RestController
@RequestMapping("/sidogugun")
public class SidoGugunController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	SidoGugunService sidoGugunService;
	public SidoGugunController(SidoGugunService sidoGugunService) {
		super();
		this.sidoGugunService = sidoGugunService;
	}
	
	@GetMapping()
	public List<SidoDto> getSidos() throws Exception{
		return sidoGugunService.getSido();
	}
	
	@GetMapping("/{gugun}")
	public List<GugunDto> getGuguns(@PathVariable("gugun") int gugun ) throws Exception{
		return sidoGugunService.getGugun(gugun);
	}
}
