package com.himalaya.repository.impl;

import com.himalaya.repository.IAccountDao;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月13日 上午9:24:16
* Description
*/
public class AccountDaoImpl implements IAccountDao{

	@Override
	public void add(int account, Double amount) {
		System.out.println(account);
	}

	@Override
	public void deduct(int account, Double amount) {
		System.out.println(account);
	}
}
