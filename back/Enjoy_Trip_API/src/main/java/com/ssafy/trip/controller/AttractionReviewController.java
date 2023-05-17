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

import com.ssafy.trip.model.dto.ReviewDto;
import com.ssafy.trip.service.AttractionReviewService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/attrReview")
@Api("관광지 리뷰 컨트롤러  API V1")
public class AttractionReviewController {
	private final Logger logger = LoggerFactory.getLogger(AttractionReviewController.class);
	AttractionReviewService attractionReviewService;
	public AttractionReviewController(AttractionReviewService attractionReviewService) {
		super();
		this.attractionReviewService = attractionReviewService;
	}

	@ApiOperation(value = "리뷰 목록", notes = "선택한 관광지의 댓글들을 반환한다.", response = List.class)
	@GetMapping("/{attractionNo}")
	public List<ReviewDto> list(@PathVariable("attractionNo") int attractionNo) throws Exception {
		logger.debug("list attractionNo : {}", attractionNo);
		List<ReviewDto> list = attractionReviewService.list(attractionNo);
		return list;
	}

	@ApiOperation(value = "리뷰 작성", notes = "리뷰를 작성한다. attNo, content, userNo 필수. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public String write(ReviewDto reviewDto) throws Exception {
		logger.debug("write boardNo : {}", reviewDto.getAttractionNo());
		attractionReviewService.write(reviewDto);
		return "success";
	}

	@ApiOperation(value = "리뷰 수정", notes = "리뷰를 수정한다. content, reviewNo 필수. 그리고 수정된 리뷰 객체 ReviewDto를 반환한다.", response = ReviewDto.class)
	@PutMapping
	public ReviewDto modify(ReviewDto reviewDto) throws Exception {
		logger.debug("modify ReviewDto : {}", reviewDto);
		attractionReviewService.modify(reviewDto);
		return reviewDto;
	}

	@ApiOperation(value = "리뷰 삭제", notes = "리뷰를 삭제한다.", response = String.class)
	@DeleteMapping("/{reviewNo}")
	public String delete(@PathVariable("reviewNo") int reviewNo) throws Exception {
		logger.debug("delete reviewNo : {}", reviewNo);
		attractionReviewService.delete(reviewNo);
		return "success";
	}
}
