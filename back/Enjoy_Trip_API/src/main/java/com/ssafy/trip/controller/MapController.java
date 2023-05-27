package com.ssafy.trip.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.trip.model.dto.AttractionDto;
import com.ssafy.trip.model.dto.SearchDto;
import com.ssafy.trip.service.MapService;
@CrossOrigin("*")
@RestController
@RequestMapping("/map")
public class MapController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	private MapService mapService;

	public MapController(MapService mapService) {
		super();
		this.mapService = mapService;
	}

	@GetMapping("/{attrNo}/{userNo}")
	public AttractionDto detail(@PathVariable int attrNo, @PathVariable int userNo) throws Exception {
		logger.debug("attraction_no detail : {}", attrNo);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("attrNo", attrNo);
		map.put("userNo", userNo);
		return mapService.getAttr(map);
	}

	@PostMapping("")
	public List<AttractionDto> search(@RequestBody SearchDto searchDto) throws Exception {
		logger.debug("searchDto info : {}", searchDto);
		List<AttractionDto> attractionDto = mapService.search(searchDto);
		return attractionDto;
	}

	@GetMapping("/watch/{userNo}")
	public List<AttractionDto> watchlist(@PathVariable("userNo") int userNo) throws Exception {
		logger.debug("get recently watched list of attraction");
		List<AttractionDto> list = mapService.watch(userNo);
		return list;
	}
	
	@GetMapping("/chart")
	public List<AttractionDto> chartlist() throws Exception{
		List<AttractionDto> list = mapService.chart();
		return list;
	}
}