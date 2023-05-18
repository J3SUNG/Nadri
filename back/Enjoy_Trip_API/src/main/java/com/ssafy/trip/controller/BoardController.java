package com.ssafy.trip.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.trip.model.dto.BoardDto;
import com.ssafy.trip.model.dto.BoardParameterDto;
import com.ssafy.trip.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/board")
@Api("게시판 컨트롤러  API V1")
public class BoardController {
	private final Logger logger = LoggerFactory.getLogger(BoardController.class);
	BoardService boardService;
	public BoardController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}
	
	@ApiOperation(value = "게시판 글작성", notes = "새로운 게시글 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping("")
	public String write(@RequestBody BoardDto boardDto,
			RedirectAttributes redirectAttributes, HttpSession session) throws Exception {
		session.setAttribute("hello", "hello");
		System.out.println("save");
		System.out.println((String) session.getAttribute("hello"));
//		logger.debug("write boardDto : {}", data);
		logger.debug("write boardDto : {}", boardDto);
		boardDto.setUserNo(7);
//		boardDto.setContent("asdlkfjsdklfj");
//		boardDto.setBoardType(1);
//		
		boardService.writeArticle(boardDto);
		
//		redirectAttributes.addAttribute("pgno", "1"); //paging 처리
//		redirectAttributes.addAttribute("key", "");
//		redirectAttributes.addAttribute("word", "");
		//return "redirect:/article/list"; //글 작성 후 1페이지로 redirect
		return "success";
	}

	@ApiOperation(value = "게시판 글목록", notes = "필수 : type / 모든 게시글의 정보를 반환한다. ", response = List.class)
	@GetMapping
	public List<BoardDto> list(@ApiParam(value = "게시글을 얻기위한 부가정보.", required = true) BoardParameterDto boardParameterDto) throws Exception {
		logger.debug("list parameter boardType : {}", boardParameterDto);
		if(boardParameterDto.getType()=="0") {
			boardParameterDto.setSpp(20);
		} else {
			boardParameterDto.setSpp(21);
		}
		List<BoardDto> list = boardService.listArticle(boardParameterDto);
		//		type 0일때 20 1일때 15로 글 개수 고정 ###############
		
//		페이지네이션 처리 보류, 이전에는 model&view를 사용하요 pageNavigation 전달
		//left pgno
		// right pgno
		// pgno
		//left pg = true; 
		//right pg = true;
		//endpg = ture;
		return list;
	}
	@ApiOperation(value = "게시판 글보기", notes = "글번호에 해당하는 게시글의 정보를 반환한다.", response = BoardDto.class)
	@GetMapping("/{boardNo}")
	public BoardDto view(@PathVariable("boardNo") int boardNo)
			throws Exception {
		logger.debug("view boardNo : {}", boardNo);
		BoardDto boardDto = boardService.getArticle(boardNo);
//		model.addAttribute("article", boardDto);  	//paging 처리
		return boardDto;
	}

	@ApiOperation(value = "게시판 글수정", notes = "필수 : subject content boardNo || 수정할 게시글 정보를 입력한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("")
	public String modify(@RequestBody BoardDto boardDto, 
			RedirectAttributes redirectAttributes) throws Exception {//@RequestParam Map<String, String> map,
		logger.debug("modify boardDto : {}", boardDto);
		boardService.modifyArticle(boardDto);
//		redirectAttributes.addAttribute("pgno", map.get("pgno")); //paging 처리
		return "success";
	}

	@ApiOperation(value = "게시판 글삭제", notes = "글번호에 해당하는 게시글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/{boardNo}")
	public String delete(@PathVariable("boardNo") int boardNo) throws Exception {
		logger.debug("delete articleNo : {}", boardNo);
		boardService.deleteArticle(boardNo);
//		redirectAttributes.addAttribute("pgno", map.get("pgno"));//paging 처리
		return "success";
	}
}
