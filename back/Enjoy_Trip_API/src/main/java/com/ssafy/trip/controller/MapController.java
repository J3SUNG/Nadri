package com.ssafy.trip.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.trip.model.dto.AttractionDto;
import com.ssafy.trip.model.dto.SearchDto;
import com.ssafy.trip.service.MapService;

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
		//UserDto userDto = (UserDto) session.getAttribute("userinfo"); //test시 주석
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("attrNo", attrNo);
		map.put("userNo",userNo );//test userDto.getId()
//		logger.debug(map.toString());	
		return mapService.getAttr(map);
//		return null;
	}

	@PostMapping("")
	public List<AttractionDto> search(@RequestBody SearchDto searchDto) throws Exception {
		logger.debug("searchDto info : {}", searchDto);
		List<AttractionDto> attractionDto = mapService.search(searchDto);
		return attractionDto;
	}
}