package com.himalaya.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.himalaya.entity.UserDO;
import com.himalaya.redis.RedisConnectionUtil;

import redis.clients.jedis.Jedis;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年5月11日 下午4:31:40
* Description
*/
public class ServiceImplTest {

	protected ClassPathXmlApplicationContext ctx;
	
	ServiceImpl service = null;

	@Before
	public void setUp() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (ServiceImpl)ctx.getBean("serviceImpl");
	}

	@After
	public void tearDown() {
		if (ctx != null) {
			ctx.close();
		}
	}
	
	@Test
	public void testGet() throws Exception {
		
		System.out.println(service.get("222"));
	}
	
	@Test
	public void testGetUser() throws Exception {
		UserDO user = new UserDO();
		user.setId(423);
		user.setName("balabalabala");
		System.out.println(service.get(user));
	}
}
