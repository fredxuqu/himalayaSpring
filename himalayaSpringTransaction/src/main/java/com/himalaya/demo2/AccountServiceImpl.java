package com.himalaya.demo2;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月13日 上午9:25:15
* Description
*/
public class AccountServiceImpl implements IAccountService{

	private IAccountDao accountDao;
		
	public void setAccountDao(IAccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void transfer(String inAccount, String outAccount, Double transferAmount) {
		
		accountDao.deduct(outAccount, transferAmount);
//		int i = 1/0;
		accountDao.add(inAccount, transferAmount);
	}
}