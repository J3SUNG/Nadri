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
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.trip.model.dto.BoardDto;
import com.ssafy.trip.model.dto.BoardListDto;
import com.ssafy.trip.model.dto.BoardPageDto;
import com.ssafy.trip.model.dto.BoardParameterDto;
import com.ssafy.trip.model.dto.FileInfoDto;
import com.ssafy.trip.service.BoardLikeService;
import com.ssafy.trip.service.BoardService;
import com.ssafy.trip.util.PageNavigation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin("*")
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
	@PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public String write(@RequestParam(value = "imgs", required = false) List<MultipartFile> imgs, BoardDto boardDto)
			throws Exception { // , BoardDto boardDto

		logger.debug("게시판 글 작성 boardDto : {}", boardDto);

		if (!(imgs == null)) {
			logger.debug(imgs.get(0).getOriginalFilename());

			String realPath = new File("").getAbsolutePath() + "/resources/img";
			String today = new SimpleDateFormat("yyMMdd").format(new Date());
			String saveFolder = realPath + File.separator + today;
			logger.debug("저장 폴더 : {}", saveFolder);
			File folder = new File(saveFolder);
			if (!folder.exists())
				folder.mkdirs();
			List<FileInfoDto> fileInfos = new ArrayList<FileInfoDto>();
			for (MultipartFile mfile : imgs) {
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

			boardDto.setSaveFile(fileInfos.get(0).getSaveFile());
			boardDto.setSaveFolder(fileInfos.get(0).getSaveFolder());
			boardDto.setFileInfos(fileInfos);
		} else {
			boardDto.setSaveFile("no_img.png");
			boardDto.setSaveFolder("image1");
			boardDto.setFileInfos(null);
		}

		boardService.writeArticle(boardDto);
		return "success";
	}

	@ApiOperation(value = "게시판 글목록", notes = "필수 : type / 모든 게시글의 정보를 반환한다. ", response = List.class)
	@GetMapping
	public BoardPageDto list(@ApiParam(value = "게시글을 얻기위한 부가정보.", required = true, example = "10") BoardParameterDto boardParameterDto)
			throws Exception {
		logger.debug("list parameter boardType : {}", boardParameterDto);
		if ("0".equals(boardParameterDto.getType())) {
			boardParameterDto.setSpp(10);
			boardParameterDto.setKey("subject");
			logger.debug("공지사항");
		} else {
			boardParameterDto.setSpp(21);
			logger.debug("게시판");
		}
		List<BoardListDto> list = boardService.listArticle(boardParameterDto);
		PageNavigation pageNavigation = boardService.makePageNavigation(boardParameterDto);
		BoardPageDto boardPageDto = new BoardPageDto(pageNavigation, list);
		return boardPageDto;
	}

	@ApiOperation(value = "게시판 글보기", notes = "글번호에 해당하는 게시글의 정보를 반환한다.", response = BoardDto.class)
	@GetMapping("/{boardNo}/{userNo}")
	public BoardDto view(@PathVariable("boardNo") int boardNo, @PathVariable("userNo") int userNo) throws Exception {
		logger.debug("view boardNo : {}", boardNo);
		BoardDto boardDto = boardService.getArticle(boardNo, userNo);
		return boardDto;
	}

	@ApiOperation(value = "게시판 글수정", notes = "필수 : subject content boardNo || 수정할 게시글 정보를 입력한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping()
	public String modify(BoardDto boardDto) throws Exception {
		logger.debug("modify boardDto : {}", boardDto);
		boardService.modifyArticle(boardDto);
		return "success";
	}

	@ApiOperation(value = "게시판 글삭제", notes = "글번호에 해당하는 게시글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/{boardNo}")
	public String delete(@PathVariable("boardNo") int boardNo) throws Exception {
		logger.debug("delete articleNo : {}", boardNo);
		boardService.deleteArticle(boardNo);
		return "success";
	}
}