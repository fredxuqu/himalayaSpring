package com.himalaya;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月13日 上午11:04:41
* Description
*/
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class BaseTestCase {
	
	protected ApplicationContext context;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
}