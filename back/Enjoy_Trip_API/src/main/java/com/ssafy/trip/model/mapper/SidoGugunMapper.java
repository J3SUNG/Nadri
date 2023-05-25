package com.ssafy.trip.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.model.dto.GugunDto;
import com.ssafy.trip.model.dto.SidoDto;

@Mapper
public interface SidoGugunMapper {

	List<SidoDto> getSido();

	List<GugunDto> getGugun(int sido);

}
