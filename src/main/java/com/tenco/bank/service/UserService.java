package com.tenco.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.bank.dto.SignInFormDto;
import com.tenco.bank.dto.SignUpFormDto;
import com.tenco.bank.handler.exception.CustomRestfullException;
import com.tenco.bank.repository.interfaces.UserRepository;
import com.tenco.bank.repository.model.User;

@Service // IoC 대상 (싱글톤 패턴으로 관리)
public class UserService {
	
	@Autowired // DI 처리 (객체 생성시 의존 주의 처리)
	private UserRepository userRepository;
	
	@Autowired // DI 처리 - webcofig에서 IoC 처리 함
	private PasswordEncoder passwordEncoder;
	
	// 메서드 호출이 시작될 때 트랜잭션에 시작
	// 메서드 종료시 트랜잭션 종료 (commit)
	@Transactional 
	public void createUser(SignUpFormDto signUpFormDto) {
		
		String rawPwd = signUpFormDto.getPassword();
		String hashPwd = passwordEncoder.encode(rawPwd);
		signUpFormDto.setPassword(hashPwd); // 객체 상태 변경
		
		// SignUpFormDto
		// User
		int result = userRepository.insert(signUpFormDto);
		if(result != 1) {
			throw new CustomRestfullException("회원 가입 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * 로그인 서비스 처리
	 * @param signInFormDto
	 * @return userEntity 응답
	 */
	@Transactional
	public User signIn(SignInFormDto signInFormDto) {
		
		// todo
		// userRepository.xxx() 호출
		User userEntity = userRepository.findByUsernameAndPassword(signInFormDto);
		if(userEntity == null) {
			throw new CustomRestfullException("아이디 혹은 비번이 틀렸습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return userEntity;
		
	}
	
}
