package com.ssafy.trip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.trip.service.CrawlingServiceImpl;

@RestController
@RequestMapping("/craw")
public class CrawlingController {
	@Autowired
	CrawlingServiceImpl crawService = new CrawlingServiceImpl();
	
	@GetMapping
	public String getNews() {
		return crawService.crawling();
	}
}
