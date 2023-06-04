package com.ssafy.trip.service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class CrawlingServiceImpl {
	public String crawling() {
	    String URL = "https://www.joongang.co.kr/travel/domestic";
	    Document doc;

	    try {
	        doc = Jsoup.connect(URL)
	                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
	                .get(); // 원하는 url에서 전체 구조를 받아온다
	        Elements elem = doc
	                .select("section > div.photo_list_area > ul > li");
	        
	        return elem.toString();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return "error";
	}
}
