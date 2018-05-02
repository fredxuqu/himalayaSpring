package com.himalaya;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: xuqu
 * @E-mail: fredxuqu@163.com
 * @version 2018年5月2日 下午5:23:52 Description
 */
public class BaseTestCase {

	protected ClassPathXmlApplicationContext ctx;

	@Before
	public void setUp() {
		ctx = new ClassPathXmlApplicationContext("application.xml");
	}

	@After
	public void tearDown() {
		if (ctx != null) {
			ctx.close();
		}
	}
}
