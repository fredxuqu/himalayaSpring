package com.himalaya.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.himalaya.entity.Account;

@MapperScan
public interface AccountMapper {
    
	int insert(Account account);
    
    int delete(Account account);
    
    int updateAmount(Account account);

    List<Account> listAll();
}