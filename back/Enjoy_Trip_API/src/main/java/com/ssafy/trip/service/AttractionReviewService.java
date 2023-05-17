package com.ssafy.trip.service;

import java.util.List;

import com.ssafy.trip.model.dto.ReviewDto;

public interface AttractionReviewService {

	List<ReviewDto> list(int attractionNo);

	void write(ReviewDto reviewDto);

	void modify(ReviewDto reviewDto);

	void delete(int reviewNo);

}
