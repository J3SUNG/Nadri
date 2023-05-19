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

	@GetMapping("/{attrNo}")
	public AttractionDto detail(@PathVariable String attrNo, HttpSession session) throws Exception {
		logger.debug("attraction_no info : {}", attrNo);
		//UserDto userDto = (UserDto) session.getAttribute("userinfo"); //test시 주석
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("attrNo", attrNo);
		map.put("userid","7" );//test userDto.getId()
		return mapService.getAttr(map);
	}

	@PostMapping("")
	public List<AttractionDto> search(@RequestBody SearchDto searchDto) throws Exception {
		logger.debug("searchDto info : {}", searchDto);
		List<AttractionDto> attractionDto = mapService.search(searchDto);
		return attractionDto;
	}
}