package com.tenco.bank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.tenco.bank.handler.AuthInterceptor;

@Configuration // IoC 등록
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Autowired // DI 
	private AuthInterceptor authInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor)
				.addPathPatterns("/account/**")
				.addPathPatterns("/auth/**"); // 1. path 더 추가 하는 방법
		
		// 인터 셉터 등록
		// registry.addInterceptor(new AdminInterceptor()); // 2. 인터셉터 
	}
}
