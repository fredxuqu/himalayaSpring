package com.himalaya.demo4;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月13日 上午11:24:44
* Description
*/
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:applicationContext4.xml"})
public class AccountDaoImplTest {
	
	@Autowired
	IAccountDao dao;
	
	protected ApplicationContext context;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testAddAcount(){
		dao.addAccount("Jim", 200d);
	}
	
	@Test
	public void testListAll(){
		List<String> list = dao.listAllAccount();
		for (String string : list) {
			System.out.println(string);
		}
	}
}