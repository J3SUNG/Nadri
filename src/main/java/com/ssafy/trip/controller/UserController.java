package com.ssafy.trip.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
		UserDto userDto = (UserDto) session.getAttribute("userinfo");
		
		//UserDto userDto = new UserDto();   //test code
		//userDto.setId("ssafy");//
		return userService.getUser(userDto.getId());
	}
	
	@PostMapping("")
	public String join(@RequestBody UserDto userDto) {
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
		logger.debug("userDto info : {}", userDto);
		//userService.modifyUser(userDto); //test code
		session.setAttribute("userinfo", userDto);
		return "회원 수정";
	}

	@DeleteMapping("")
	public String deleteUser(HttpSession session) throws Exception {
		UserDto userDto = (UserDto) session.getAttribute("userinfo");
		
		//UserDto userDto = new UserDto();   //test code
		//userDto.setId("asdasd");//
		userService.deleteUser(userDto.getId());
		session.removeAttribute("userinfo");
		return "회원 삭제";
	}

	@GetMapping("/idCheck/{id}")
	@ResponseBody
	public String idCheck(@PathVariable("id") String id) throws Exception {
		logger.debug("idCheck id : {}", id);
		int cnt = userService.idCheck(id);
		return cnt + "";
	}
}
