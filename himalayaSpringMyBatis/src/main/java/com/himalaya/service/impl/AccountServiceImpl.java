package com.himalaya.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.himalaya.dao.AccountMapper;
import com.himalaya.entity.Account;
import com.himalaya.service.IAccountService;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月13日 上午9:25:15
* Description
*/
@Service
public class AccountServiceImpl implements IAccountService {
	
	@Resource
	private AccountMapper dao;

	@Override
//	@Transactional
	public void transfer(String inAccount, String outAccount, Double amount) {
		
		Account deductAccount = new Account();
		deductAccount.setAccount(inAccount);
		deductAccount.setAmount(0-amount);
		dao.updateAmount(deductAccount);
		
		Account addAcount = new Account();
		addAcount.setAccount(inAccount);
		addAcount.setAmount(amount);
		dao.updateAmount(addAcount);
	}
}