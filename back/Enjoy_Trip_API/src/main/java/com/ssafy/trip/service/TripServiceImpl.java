package com.ssafy.trip.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.trip.model.dto.PlanDto;
import com.ssafy.trip.model.dto.TripDto;
import com.ssafy.trip.model.mapper.TripMapper;

@Service
public class TripServiceImpl implements TripService {
	TripMapper tripMapper;

	public TripServiceImpl(TripMapper tripMapper) {
		super();
		this.tripMapper = tripMapper;
	}

	@Override
	public TripDto get(int tripNo) {
		return tripMapper.get(tripNo);
	}

	@Override
	public List<TripDto> list(int planNo) {
		return tripMapper.list(planNo);
	}

	@Override
	public void write(TripDto tripDto) {
		tripMapper.write(tripDto);
	}

	@Override
	public void modify(TripDto tripDto) {
		tripMapper.modify(tripDto);
	}

	@Override
	public void delete(int tripDto) {
		tripMapper.delete(tripDto);
	}

	@Override
	public void write(TripDto tripDto, int planNo) {
		tripDto.setPlanNo(planNo);
		tripMapper.write(tripDto);
	}

}
