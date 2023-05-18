package com.ssafy.trip.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.trip.model.dto.GugunDto;
import com.ssafy.trip.model.dto.SidoDto;
import com.ssafy.trip.model.mapper.SidoGugunMapper;

@Service
public class SidoGugunServiceImpl implements SidoGugunService {
	SidoGugunMapper sidoGugunMapper; 
	public SidoGugunServiceImpl(SidoGugunMapper sidoGugunMapper) {
		super();
		this.sidoGugunMapper = sidoGugunMapper;
	}

	@Override
	public List<SidoDto> getSido() {
		return sidoGugunMapper.getSido();
	}

	@Override
	public List<GugunDto> getGugun(int sido) {
		return sidoGugunMapper.getGugun(sido);
	}

}
