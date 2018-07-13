package com.himalaya.demo1;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月13日 上午9:25:15
* Description
*/
public class AccountServiceImpl implements IAccountService{

	private IAccountDao accountDao;
	
	private TransactionTemplate transctionTemplate;
	
	public void setAccountDao(IAccountDao accountDao) {
		this.accountDao = accountDao;
	}	

	public void setTransctionTemplate(TransactionTemplate transctionTemplate) {
		this.transctionTemplate = transctionTemplate;
	}

	@Override
	public void transfer(String inAccount, String outAccount, Double transferAmount) {
		
		transctionTemplate.execute(new TransactionCallbackWithoutResult() {
						
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
				accountDao.deduct(outAccount, transferAmount);
				int i = 1/0;
				accountDao.add(inAccount, transferAmount);
			}
		});
	}
}