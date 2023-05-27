package com.ssafy.trip.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.trip.model.dto.CommentDto;
import com.ssafy.trip.service.CommentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
@CrossOrigin("*")
@RestController
@RequestMapping("/comment")
public class CommentController {
	private final Logger logger = LoggerFactory.getLogger(BoardController.class);
	CommentService commentService;

	public CommentController(CommentService commentService) {
		super();
		this.commentService = commentService;
	}

	@GetMapping("/{boardNo}")
	public List<CommentDto> list(@PathVariable("boardNo") int boardNo) throws Exception {
		logger.debug("list boardNo : {}", boardNo);
		List<CommentDto> list = commentService.list(boardNo);
		return list;
	}

	@PostMapping("/{content}/{userNo}/{boardNo}")
	public String write(@PathVariable String content, @PathVariable String userNo, @PathVariable String boardNo) {
		logger.debug("write boardNo : {} {} {}", content, userNo, boardNo);
		CommentDto commentDto = new CommentDto();
		commentDto.setContent(content);
		commentDto.setUserNo(Integer.parseInt(userNo));
		commentDto.setBoardNo(Integer.parseInt(boardNo));
		commentService.write(commentDto);
		return "success";
	}

	@PutMapping("")
	public CommentDto modify(@RequestBody CommentDto commentDto) throws Exception {
		logger.debug("modify commentDto : {}", commentDto);
		commentService.modify(commentDto);
		return commentDto;
	}

	@DeleteMapping("/{commentNo}")
	public String delete(@PathVariable("commentNo") int commentNo) throws Exception {
		logger.debug("delete commentNo : {}", commentNo);
		commentService.delete(commentNo);
		return "comment delete success";
	}
}
