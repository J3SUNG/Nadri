package com.ssafy.trip.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.model.dto.ReviewDto;

@Mapper
public interface AttractionReviewMapper {

	List<ReviewDto> list(int attractionNo);

	void write(ReviewDto reviewDto);

	void modify(ReviewDto reviewDto);

	void delete(int reviewNo);

}
