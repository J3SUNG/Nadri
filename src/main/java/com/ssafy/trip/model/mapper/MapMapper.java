package com.ssafy.trip.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.ssafy.trip.model.dto.AttractionDto;
import com.ssafy.trip.model.dto.SearchDto;

@Mapper
public interface MapMapper {

	List<AttractionDto> search(SearchDto searchDto);

	AttractionDto getAttr(String attrNo);

	void visitLog(Map<String, Object> map);

}
