package com.himalaya.dao.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.himalaya.repository.IAccountDao;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月13日 上午11:24:44
* Description
*/
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class DaoImplTest {
	
	@Value("${spring.druid.datasource.type}")
	private String type;
	
	@Autowired
	IAccountDao accountDao;
	
	protected ApplicationContext context;
	
	@Before
	public void setUp() throws Exception {
		System.out.println(type);
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testSave(){
		System.out.println(type);
		accountDao.add(1, 1.0d);
	}
}
