package com.tenco.bank.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.bank.repository.model.Account;

@Mapper
public interface AccountRepository {
	
	public int insert(Account account);
	public int updateById(Account account);
	public int deleteById(int id);
	
	public List<Account> findAll();
	public Account findById(int id);
	
	public List<Account> findByUserId(Integer userId);
	
	// 코드 추가 - 계좌 번호로 찾는 기능 추가
	public Account findByNumber(String number);
}
