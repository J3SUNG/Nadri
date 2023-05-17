package com.ssafy.trip.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.trip.model.dto.UserDto;
import com.ssafy.trip.service.UserService;

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

	@GetMapping("")
	public UserDto getUser(HttpSession session) throws Exception {
	/**
	 * session에서 로그인 되어있는 userDto를 가져와서 
	 * 결과로 userDto.id에 해당하는 사용자의 정보를 UserDto 형태로 반환한다.
	 */
		//UserDto userDto = (UserDto) session.getAttribute("userinfo");
		
		UserDto userDto = new UserDto();   //test code
		userDto.setId("ssafy");//
		return userService.getUser(userDto.getId());
	}
	
	@PostMapping("")
	public String join(@RequestBody UserDto userDto) {
		/**
		 * 회원가입 화면에서 회원가입에 필요한 정보를 입력받아 넘기면 해당 정보로 가입을 진행한다.(유효성 검사 완료된 정보가 넘어온다.)
		 * 결과로 '회원가입 성공', '회원가입 실패'를 반환한다.
		 */
		logger.debug("userDto info : {}", userDto);
		try {
			userService.joinUser(userDto);
			return "회원가입 성공";
		} catch (Exception e) {
			e.printStackTrace();
			return "회원가입 실패"; // error 페이지 연결
		}
	}
	
	@PutMapping("")
	public String ModifyUser(@RequestBody UserDto userDto, HttpSession session) throws Exception {
		/**
		 * 회원 정보 수정을 위한 userDto를 받아서 받은 내용 그대로 회원 정보를 수정한다.
		 * 수정된 내용으로 session에 등록된 로그인 정보를 재등록한다. 이메일, 닉네임만 변경
		 * 결과로 '회원 수정' 반환
		 */
		logger.debug("modify userDto info : {}", userDto);
		userService.modifyUser(userDto);
		session.setAttribute("userinfo", userDto);
		return "회원 수정";
	}

	@DeleteMapping("")
	public String deleteUser(HttpSession session) throws Exception {
		/**
		 * session에 등록되어 있는 사용자 정보를 받아와 해당 사용자를 탈퇴시키기 위해
		 * user 테이블에서 해당 레코드를 삭제한다.
		 * 결과로 '회원삭제'를 반환한다.
		 */
		//UserDto userDto = (UserDto) session.getAttribute("userinfo");
		
		UserDto userDto = new UserDto(); userDto.setId("user5");   //test code
		userService.deleteUser(userDto.getId());
		session.removeAttribute("userinfo");
		return "회원 삭제";
	}

	@GetMapping("/check")
	public String dupulicateCheck(@RequestParam("field") String field, @RequestParam("val") String val) throws Exception {
		/**
		 * col에 해당하는 항목의 val에 대해서 일치하는 데이터의 개수를 반환한다.
		 */
		logger.debug("check : {} || value : {}", field, val);
		Map<String, String> map = new HashMap<String,String>();
		map.put("field",field);
		map.put("val",val);
		int cnt = userService.check(map);
		return cnt + "";
	}
	
	@GetMapping("/authEmail")
	public String authEmail(@RequestParam("email") String email, @RequestParam("id") String id) throws Exception{
		if(email==null|id==null) {
			return "fail";
		}
		Map<String, String> map = new HashMap<String,String>();
		map.put("email",email);
		map.put("id",id);
		if(userService.authEmail(map)) {
			//일치하는 회원 확인됨.
			
			//인증번호 생성 : 랜덤한 4자리 숫자 생성, 세션?? 에 유효시간 3분으로 저장
			//메일 전송
			//사용자 입력 대기... 입력 들어옴
			//현재 유지하고 있는 인증번호와 동일한지 확인
			  //동일하면 성공
			  //아니면 실패 반환
		} else {
			return "fail";
		}
		return "success";
	}
}
