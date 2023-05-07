package com.ssafy.trip.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.trip.model.dto.BoardDto;
import com.ssafy.trip.model.dto.CommentDto;
import com.ssafy.trip.service.CommentService;

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
	public List<CommentDto> list(@PathVariable("boardNo") int boardNo) throws Exception{
		logger.debug("list boardNo : {}", boardNo);
		List<CommentDto> list = commentService.list(boardNo);
		return list;
	}
	
	@PostMapping("")
	public String write(CommentDto commentDto) {
		logger.debug("write boardNo : {}", commentDto.getBoardNo());
		commentService.write(commentDto);
		return "댓글 작성 성공";
	}
	
	@PutMapping("")
	public CommentDto modify(CommentDto commentDto) throws Exception {
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
