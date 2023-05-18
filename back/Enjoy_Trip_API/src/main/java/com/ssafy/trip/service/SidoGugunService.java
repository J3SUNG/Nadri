package com.ssafy.trip.service;

import java.util.List;
import java.util.Map;

import com.ssafy.trip.model.dto.GugunDto;
import com.ssafy.trip.model.dto.SidoDto;

public interface SidoGugunService {

	List<SidoDto> getSido();

	List<GugunDto> getGugun(int gugun);

}
