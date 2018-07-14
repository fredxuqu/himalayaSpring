package com.himalaya.service.impl;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.himalaya.service.IAccountService;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月14日 下午5:54:47
* Description
*/
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class AccountServiceImplTest {
	
	@Resource
	IAccountService service;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testTransfer(){
		service.transfer("Fred", "Wendy", 100d);
	}
}
