package com.himalaya.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.himalaya.redis.RedisConnectionUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;


public class RedisConnectionUtilTest {

	protected ClassPathXmlApplicationContext ctx;
	
	RedisConnectionUtil redisConnectionUtil = null;

	@Before
	public void setUp() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		redisConnectionUtil = (RedisConnectionUtil)ctx.getBean("redisConnectionUtil");
	}

	@After
	public void tearDown() {
		if (ctx != null) {
			ctx.close();
		}
	}
	
	@Test
	public void testJedis() throws Exception {
		
		Jedis jedis = redisConnectionUtil.getJedis();
		jedis.set("key1", "1234567890");
		System.out.println("Get data from redis by key [key1] " + jedis.get("key1"));
	}
	
	@Test
	public void testPipeline() throws Exception {
		
		Pipeline pipeline = redisConnectionUtil.getJedis().pipelined();
		pipeline.set("key2", "FRED");
		pipeline.sync();
		System.out.println("Get data from redis by key [key2] " + redisConnectionUtil.getJedis().get("key2"));
	}
}
