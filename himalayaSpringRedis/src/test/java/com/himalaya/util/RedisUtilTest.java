package com.himalaya.util;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.himalaya.redis.RedisUtil;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class RedisUtilTest {
	
	@Autowired
	@Qualifier("redisUtil")
	RedisUtil redisUtil;
	
	@Test
	public void testJedis() throws Exception {
		redisUtil.set("key1", "1234567890");
		System.out.println("Get data from redis by key [key1] " + redisUtil.get("key1"));
	}
	
	@Test
	public void testPipeline() throws Exception {
		redisUtil.pipeSet("key2", "FRED");
		System.out.println("Get data from redis by key [key2] " + redisUtil.get("key2"));
	}
	
	@Test
	public void testPerformance() throws Exception {
		System.out.println("Jedis Operation: ");
		long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
        	redisUtil.set(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        }
        System.out.println(System.currentTimeMillis() - start);
        
        System.out.println("Pipeline Operation: ");
        start = System.currentTimeMillis();
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 100000; i++) {
            map.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        }
        redisUtil.batchPipeSet(map);
        System.out.println(System.currentTimeMillis() - start);
	}
	
	@After
	public void tearDown() throws Exception {
	}
}
