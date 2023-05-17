package com.ssafy.trip.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.trip.model.dto.UserDto;
import com.ssafy.trip.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	private LoginService loginService;
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	public LoginController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}
	
	@PostMapping("")
	public UserDto login(@RequestParam Map<String, String> map,
			@RequestParam(name = "saveid", required = false) String saveid, Model model, HttpSession session,
			HttpServletResponse response) {
		logger.debug("login map : {}", map);
		try {
			UserDto userDto = loginService.login(map);
			if (userDto != null) {
				session.setAttribute("userinfo", userDto);

				Cookie cookie = new Cookie("ssafy_id", map.get("id"));
				cookie.setPath("/board");
				if ("ok".equals(saveid)) {
					cookie.setMaxAge(60 * 60 * 24 * 365 * 40);
				} else {
					cookie.setMaxAge(0);
				}
				response.addCookie(cookie);
				return userDto;
			} else {
				model.addAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요!");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "로그인 중 문제 발생!!!");
			return null;// error 페이지로 이동
		}
	}
	
	@DeleteMapping("")
	public void logout(HttpSession session) throws Exception {
		session.invalidate();
	}
}
