package com.tenco.bank.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.bank.repository.model.Account;

@Mapper
public interface AccountRespository {
	
	public int insert();
	public int updateById();
	public int deleteById();
	
	public List<Account> findAll();
	public Account findById();
}
