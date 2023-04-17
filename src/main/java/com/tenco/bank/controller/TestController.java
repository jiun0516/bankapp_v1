package com.tenco.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@GetMapping("/main")
	public String mainTest() {
		
		// viewResolver 동작
		// prefix : /WEB-INF/view
		// subfix : .jsp
		
		// /WEB-INF/view/
		// .jsp
		// -> layout/main
		// 파일 이름 리턴 처리
		return "layout/main";
	}
}
