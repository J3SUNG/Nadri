package com.ssafy.trip.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.trip.controller.BoardController;
import com.ssafy.trip.model.dto.BoardDto;
import com.ssafy.trip.model.dto.BoardListDto;
import com.ssafy.trip.model.dto.BoardParameterDto;
import com.ssafy.trip.model.dto.FileInfoDto;
import com.ssafy.trip.model.mapper.BoardMapper;
import com.ssafy.trip.util.PageNavigation;

@Service
public class BoardServiceImpl implements BoardService {
	private final Logger logger = LoggerFactory.getLogger(BoardController.class);
	BoardMapper boardMapper;
	public BoardServiceImpl(BoardMapper boardMapper) {
		super();
		this.boardMapper = boardMapper;
	}

	@Override
	public List<BoardListDto> listArticle(BoardParameterDto boardParameterDto) throws Exception {
		logger.debug("list parameter boardType : {}", boardParameterDto.getType());
		Map<String, Object> param = new HashMap<String, Object>();
		String key = boardParameterDto.getKey();
		if ("user_no".equals(key))
			key = "b.user_no";
		param.put("key", key == null ? "" : key);
		param.put("word", boardParameterDto.getWord() == null ? "" : boardParameterDto.getWord());
		int pgNo = boardParameterDto.getPg() == 0 ? 1 : boardParameterDto.getPg();
//		int start = pgNo * SizeConstant.LIST_SIZE - SizeConstant.LIST_SIZE;
		int start = pgNo * boardParameterDto.getSpp() - boardParameterDto.getSpp();
		param.put("start", start);
		param.put("listsize", boardParameterDto.getSpp());
		param.put("boardType", boardParameterDto.getType());
		param.put("userNo", boardParameterDto.getUserNo());
		return boardMapper.listArticle(param);
	}
	
	@Override
	@Transactional
	public void writeArticle(BoardDto boardDto) throws Exception {
		boardMapper.writeArticle(boardDto);
		System.out.println(boardDto.getBoardNo());
		boardMapper.fileRegister(boardDto);
	}

		
	@Override
	public PageNavigation makePageNavigation(BoardParameterDto bParamDto) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();

		int naviSize = 5;
		int sizePerPage = bParamDto.getSpp();
		int currentPage = bParamDto.getPg();

		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		Map<String, Object> param = new HashMap<String, Object>();
		String key = bParamDto.getKey();
		if ("id".equals(key)) key = "id";
		param.put("key", key == null ? "" : key);
		param.put("word", bParamDto.getWord() == null ? "" : bParamDto.getWord());
		param.put("type",bParamDto.getType());
		int totalCount = boardMapper.getTotalArticleCount(param);
		logger.debug("total count : {}",totalCount);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
//		pageNavigation.makeNavigator();

		return pageNavigation;
	}

	@Override
	public BoardDto getArticle(int boardNo, int userNo) throws Exception {
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("boardNo", boardNo);
		map.put("userNo", userNo);
		BoardDto boardDto = boardMapper.getArticle(map);
		List<FileInfoDto> files = boardMapper.fileInfoList(boardDto.getBoardNo());
		boardDto.setFileInfos(files);
		return boardDto;
	}

	@Override
	public void modifyArticle(BoardDto boardDto) throws Exception {
		boardMapper.modifyArticle(boardDto);
	}

	@Override
	@Transactional
	public void deleteArticle(int articleNo) throws Exception {
		boardMapper.deleteArticle(articleNo);
	}



}
