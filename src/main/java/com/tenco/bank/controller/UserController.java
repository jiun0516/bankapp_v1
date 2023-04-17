package com.tenco.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenco.bank.dto.SignUpFormDto;

@Controller
@RequestMapping("/user")
public class UserController {
	
	// http://localhost:8080/user/sign-up
	@GetMapping("/sign-up")
	public String signUp() {
		// prefix
		// subfix
		return "/user/signUp";
	}
	
	// MIME TYPE : x-www-form-urlencoded
	// form : Query String 방식으로 들어 온다.
	// dto : object mapper 처리
	@PostMapping("/sign-up")
	public String signUpProc(SignUpFormDto signUpFormDto) {
		
		return "redirect:/user/sign-in";
	}
	
	
	/**
	 * 로그인 폼
	 * @param SignUpFormDto
	 * @return 로그인 페이지 
	 */
	@GetMapping("/sign-in")
	public String signIn() {
		
		return "/user/signIn";
	}
	
	/**
	 * 로그인 처리
	 * @param signUpFormDto
	 * @return 메인 페이지 이동 (수정 예정)
	 */
	@PostMapping("/sign-in")
	public String signInProc(SignUpFormDto signUpFormDto) {
		
		// todo 변경 예정
		return "/test/main";
	}
	
	
}
