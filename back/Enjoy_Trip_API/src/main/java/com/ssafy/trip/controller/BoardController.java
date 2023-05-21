package com.ssafy.trip.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.trip.model.dto.BoardDto;
import com.ssafy.trip.model.dto.BoardListDto;
import com.ssafy.trip.model.dto.BoardParameterDto;
import com.ssafy.trip.model.dto.FileInfoDto;
import com.ssafy.trip.service.BoardLikeService;
import com.ssafy.trip.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
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

	@Autowired
	BoardLikeService boardLikeService;

	@ApiOperation(value = "게시판 글작성", notes = "새로운 게시글 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping("")
	public String write(@RequestParam(required = false) MultipartFile[] files, BoardDto boardDto) throws Exception {
		logger.debug("게시판 글 작성 boardDto : {}", boardDto);

		if (!files[0].isEmpty()) {
			String realPath = new File("").getAbsolutePath() + "/resources/img";
			String today = new SimpleDateFormat("yyMMdd").format(new Date());
			String saveFolder = realPath + File.separator + today;
			logger.debug("저장 폴더 : {}", saveFolder);
			File folder = new File(saveFolder);
			if (!folder.exists())
				folder.mkdirs();
			List<FileInfoDto> fileInfos = new ArrayList<FileInfoDto>();
			for (MultipartFile mfile : files) {
				FileInfoDto fileInfoDto = new FileInfoDto();
				String originalFileName = mfile.getOriginalFilename();
				if (!originalFileName.isEmpty()) {
					String saveFileName = UUID.randomUUID().toString()
							+ originalFileName.substring(originalFileName.lastIndexOf('.'));
					fileInfoDto.setSaveFolder(today);
					fileInfoDto.setOriginalFile(originalFileName);
					fileInfoDto.setSaveFile(saveFileName);
					logger.debug("원본 파일 이름 : {}, 실제 저장 파일 이름 : {}", mfile.getOriginalFilename(), saveFileName);
					mfile.transferTo(new File(folder, saveFileName));
				}
				fileInfos.add(fileInfoDto);
			}
			boardDto.setFileInfos(fileInfos);
		}

		boardService.writeArticle(boardDto);
		//paging
		return "success";
	}

	@ApiOperation(value = "게시판 글목록", notes = "필수 : type / 모든 게시글의 정보를 반환한다. ", response = List.class)
	@GetMapping
	public List<BoardListDto> list(
			@ApiParam(value = "게시글을 얻기위한 부가정보.", required = true) BoardParameterDto boardParameterDto)
			throws Exception {
		logger.debug("list parameter boardType : {}", boardParameterDto);
		if (boardParameterDto.getType() == "0") {
			boardParameterDto.setSpp(20);
		} else {
			boardParameterDto.setSpp(21);
		}

		List<BoardListDto> list = boardService.listArticle(boardParameterDto);
//		logger.debug(list.toString());
//		int userNo = boardParameterDto.getUserNo();
//		if (userNo != 0) { // 로그인한 사용자입니다!
//			// isLike 리스트를 가져와서 list각각에 매칭해주기
//			List<BoardLikeDto> likelist = boardLikeService.list(userNo);
////			logger.debug(likelist.toString() + " 관광지 몇개? : " + list.size());
//			for (int i = 0; i < list.size(); i++) {
//				for (int j = 0; j < likelist.size(); j++) {
//					//logger.debug("boarddto : " + list.get(i).getBoardNo() + "  likedto :" + likelist.get(j).getBoardNo());
//					if (list.get(i).getBoardNo() == likelist.get(j).getBoardNo()
//							&& userNo == likelist.get(j).getUserNo()) {
//						list.get(i).setIsLike(1);
//					}
//				}
//			}
//		}
		// type 0일때 20 1일때 15로 글 개수 고정 ###############

//		페이지네이션 처리 보류, 이전에는 model&view를 사용하요 pageNavigation 전달
		// left pgno
		// right pgno
		// pgno
		// left pg = true;
		// right pg = true;
		// endpg = ture;
		return list;
	}

	@ApiOperation(value = "게시판 글보기", notes = "글번호에 해당하는 게시글의 정보를 반환한다.", response = BoardDto.class)
	@GetMapping("/{boardNo}/{userNo}")
	public BoardDto view(@PathVariable("boardNo") int boardNo, @PathVariable("userNo") int userNo) throws Exception {
		logger.debug("view boardNo : {}", boardNo);
		BoardDto boardDto = boardService.getArticle(boardNo, userNo);
		//paging 처리
		return boardDto;
	}

	@ApiOperation(value = "게시판 글수정", notes = "필수 : subject content boardNo || 수정할 게시글 정보를 입력한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("")
	public String modify(@RequestBody BoardDto boardDto, RedirectAttributes redirectAttributes) throws Exception {// @RequestParam
																													// Map<String,
																													// String>
																													// map,
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
		//paging 처리
		return "success";
	}
}
