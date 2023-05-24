package com.ssafy.trip.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.model.dto.TripDto;

@Mapper
public interface TripMapper {

	TripDto get(int tripNo);

	List<TripDto> list(int planNo);

	void write(TripDto tripDto);

	void modify(TripDto tripDto);

	void delete(int tripDto);

	void writetrip(TripDto tripDto);

}
