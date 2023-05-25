package com.ssafy.trip.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.trip.model.dto.FileInfoDto;
import com.ssafy.trip.model.dto.PlanDto;
import com.ssafy.trip.model.dto.UserDto;
import com.ssafy.trip.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping()
	public String join(@RequestBody UserDto userDto) {
		/**
		 * 회원가입 화면에서 회원가입에 필요한 정보를 입력받아 넘기면 해당 정보로 가입을 진행한다.(유효성 검사 완료된 정보가 넘어온다.) 결과로
		 * '회원가입 성공', '회원가입 실패'를 반환한다.
		 */
		logger.debug("userDto info : {}", userDto);
		try {
			userService.joinUser(userDto);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail"; // error 페이지 연결
		}
	}

	@PostMapping(value = "/modify", consumes = { org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE })
	public String ModifyUser(@RequestParam("img") MultipartFile img, UserDto userDto) throws Exception {
		/**
		 * 회원 정보 수정을 위한 userDto를 받아서 받은 내용 그대로 회원 정보를 수정한다. 수정된 내용으로 정보를 재등록한다. 이메일,
		 * 닉네임만 변경 결과로 '회원 수정' 반환
		 */
		logger.debug("modify userDto info : {}", userDto);

		if (!img.isEmpty()) {
			String realPath = new File("").getAbsolutePath() + "/resources/img";
			String today = new SimpleDateFormat("yyMMdd").format(new Date());
			String saveFolder = realPath + File.separator + today;
			logger.debug("저장 폴더 : {}", saveFolder);
			File folder = new File(saveFolder);
			if (!folder.exists())
				folder.mkdirs();
			MultipartFile mfile = img;
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
			userDto.setFile(fileInfoDto);
		}

		userService.modifyUser(userDto);
		return "success";
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable String id) throws Exception {
		userService.deleteUser(id);
		return "success";
	}

	@GetMapping("/check")
	public String dupulicateCheck(@RequestParam("field") String field, @RequestParam("val") String val)
			throws Exception {
		logger.debug("check : {} || value : {}", field, val);
		Map<String, String> map = new HashMap<String, String>();
		map.put("field", field);
		map.put("val", val);
		int cnt = userService.check(map);
		return cnt == 0 ? "success" : "fail";
	}

	@PostMapping("/change/{id}")
	public String authEmail(@PathVariable("id") String id) throws Exception {
		if (id == null) {
			return "fail";
		}
		userService.change(id);
		return "success";
	}

	@GetMapping("/like/{userNo}")
	public List<PlanDto> getLikePlan(@PathVariable("userNo") int userNo) { // 내가 찜한 플랜 3개
		List<PlanDto> list = userService.getLikePlan(userNo);
		return list;
	}
}
