package com.ssafy.trip.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
import com.ssafy.trip.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
	private final Logger logger = LoggerFactory.getLogger(BoardController.class);
	BoardService boardService;
	public BoardController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}

	@GetMapping("")
	public List<BoardDto> list(@RequestParam Map<String, String> map) throws Exception {
		//map이 가지는 정보
		/*[
		    "key": "subject",
		    "word": "제목",
		    "boardType": 0,
		    "start": 0,
		    "listsize": 10
		    "pgno" : 1
		]*/
//		Map<String,String> testmap = new HashMap<String, String>();
//		testmap.put("key","subject"); testmap.put("word","제목1"); testmap.put("boardType","0"); testmap.put("start","0"); testmap.put("listsize","10"); testmap.put("pgno","1");

		
		logger.debug("list parameter boardType : {}", map.get("boardType"));
		//ModelAndView mav = new ModelAndView();
		List<BoardDto> list = boardService.listArticle(map); //test시 testmap사용
		//페이지네이션 처리 보류, 현재는 리스트를 listsize만큼 가져옴
		//PageNavigation pageNavigation = boardService.makePageNavigation(map);
//		mav.addObject("articles", list);
//		mav.addObject("navigation", pageNavigation);
//		mav.addObject("pgno", map.get("pgno"));
//		mav.addObject("key", map.get("key"));
//		mav.addObject("word", map.get("word"));
//		mav.setViewName("board/list");
		//return mav; //list와 pagenation을 같이 담아서 view로 보낸다.
		return list;
	}
	
	@PostMapping("")
	public BoardDto write(BoardDto boardDto, HttpSession session,
			RedirectAttributes redirectAttributes) throws Exception {
		logger.debug("write boardDto : {}", boardDto);

//		boardDto.setBoardType(0);//test
//		boardDto.setContent("내용");
//		boardDto.setSubject("제목");
//		boardDto.setUserNo(7);
		boardService.writeArticle(boardDto);
//		redirectAttributes.addAttribute("pgno", "1");
//		redirectAttributes.addAttribute("key", "");
//		redirectAttributes.addAttribute("word", "");
		//return "redirect:/article/list"; //글 작성 후 1페이지로 redirect
		return boardDto;
	}


	@GetMapping("/{boardNo}")
	public BoardDto view(@PathVariable("boardNo") int boardNo, @RequestParam Map<String, String> map)
			throws Exception {
		logger.debug("view boardNo : {}", boardNo);
		BoardDto boardDto = boardService.getArticle(boardNo);
//		model.addAttribute("article", boardDto); 
//		model.addAttribute("pgno", map.get("pgno")); //paging 처리
//		model.addAttribute("key", map.get("key"));
//		model.addAttribute("word", map.get("word"));
		return boardDto;
	}


	@PutMapping("")
	public BoardDto modify(BoardDto boardDto, @RequestParam Map<String, String> map,
			RedirectAttributes redirectAttributes) throws Exception {
		logger.debug("modify boardDto : {}", boardDto);
		boardService.modifyArticle(boardDto);
//		redirectAttributes.addAttribute("pgno", map.get("pgno")); //paging 처리
//		redirectAttributes.addAttribute("key", map.get("key"));
//		redirectAttributes.addAttribute("word", map.get("word"));
//		return "redirect:/article/list";
		return boardDto;
	}

	@DeleteMapping("/{boardNo}")
	public String delete(@PathVariable("boardNo") int boardNo, @RequestParam Map<String, String> map) throws Exception {
		logger.debug("delete articleNo : {}", boardNo);
		boardService.deleteArticle(boardNo);
//		redirectAttributes.addAttribute("pgno", map.get("pgno"));//paging 처리
//		redirectAttributes.addAttribute("key", map.get("key"));
//		redirectAttributes.addAttribute("word", map.get("word"));
//		return "redirect:/article/list";
		return "board delete success";
	}
}
