package com.himalaya.demo4;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月13日 上午9:25:15
* Transactional注解的属性
*  	propagation=Propagation.REQUIRED
	isolation=Isolation.DEFAULT
	readOnly=false
	rollbackFor=
	noRollbackFor=
	
*/
public class AccountServiceImpl implements IAccountService{

	private IAccountDao accountDao;
		
	public void setAccountDao(IAccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void transfer(String inAccount, String outAccount, Double transferAmount) {
		
		accountDao.deduct(outAccount, transferAmount);
		int i = 1/0;
		accountDao.add(inAccount, transferAmount);
	}
}