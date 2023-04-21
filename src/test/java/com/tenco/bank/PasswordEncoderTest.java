package com.tenco.bank;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
	
	public static void main(String[] args) {
		// 기능 확인
		
		String password = "p1234";
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		
		System.out.println("원래 비밀번호 " + password);
		System.out.println("암호화 된 비밀번호 " + hashedPassword);
		
		// 사용자 요청 값 : 1234
		// DB 기록되어 있는 값 : $2a$10$v206mSjgYvOOErRCsT3QXujt/zfHT9UmL4cLFOyTqUQxF05P7O3Je
		
		boolean isMatched = passwordEncoder.matches(password, hashedPassword);
		System.out.println("비밀번호 일치 여부 : " + isMatched);
	}
	
	
}
