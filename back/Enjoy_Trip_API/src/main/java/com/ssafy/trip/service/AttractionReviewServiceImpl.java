package com.ssafy.trip.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.trip.model.dto.ReviewDto;
import com.ssafy.trip.model.mapper.AttractionReviewMapper;

@Service
public class AttractionReviewServiceImpl implements AttractionReviewService {
	AttractionReviewMapper reviewMapper;

	public AttractionReviewServiceImpl(AttractionReviewMapper reviewMapper) {
		super();
		this.reviewMapper = reviewMapper;
	}

	@Override
	public List<ReviewDto> list(int attractionNo) {
		return reviewMapper.list(attractionNo);
	}

	@Override
	public void write(ReviewDto reviewDto) {
		reviewMapper.write(reviewDto);
	}

	@Override
	public void modify(ReviewDto reviewDto) {
		reviewMapper.modify(reviewDto);
	}

	@Override
	public void delete(int reviewNo) {
		reviewMapper.delete(reviewNo);
	}
}
