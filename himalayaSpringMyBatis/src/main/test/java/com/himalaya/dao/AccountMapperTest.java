package com.himalaya.dao;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.himalaya.entity.Account;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月13日 上午11:24:44
* Description
*/
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class AccountMapperTest {
	@Autowired
	AccountMapper dao;
		
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testListAll(){
		List<Account> list = dao.listAll();
		for (Account account : list) {
			System.out.println(account.toString());
		}
	}
	
	@Test
	public void testInsert(){
		Account account = new Account();
		account.setAccount("duoduo");
		account.setAmount(0d);
		dao.insert(account);
	}
	
	@Test
	public void testUpdate(){
		Account account = new Account();
		account.setAccount("duoduo");
		account.setAmount(-1000d);
		dao.updateAmount(account);
	}
	
	@Test
	public void testDelete(){
		Account account = new Account();
		account.setAccount("duoduo");
		account.setAmount(1000d);
		dao.delete(account);
	}
}
