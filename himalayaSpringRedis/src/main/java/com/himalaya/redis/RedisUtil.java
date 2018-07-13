package com.himalaya.redis;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

/**
 * @author: xuqu
 * @version 2018年1月24日 下午3:37:12 Description
 */
@Component("redisUtil")
public class RedisUtil {

	@Autowired
	RedisConnectionUtil redisConnectionUtil;
	
	/**
	 * set
	 * @param key
	 * @param value
	 * @return true OR false
	 */
	public boolean set(String key, String value) {
		try {
			redisConnectionUtil.getJedis().set(key, value);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * pipeline set
	 * 
	 * @param key
	 * @param value
	 * @return true OR false
	 */
	public boolean pipeSet(String key, String value) {
		Jedis jedis = null;
		Pipeline pipe = null;
		try {
			jedis = redisConnectionUtil.getJedis();
			pipe = jedis.pipelined();
			pipe.set(key, value);
			pipe.sync();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if(pipe!=null){
				try {
					pipe.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(jedis!=null){
				jedis.close();
			}
		}
	}
	
	/**
	 * pipeline set
	 * 
	 * @param key
	 * @param value
	 * @return true OR false
	 */
	public boolean batchPipeSet(Map<String, String> map) {
		Jedis jedis = null;
		Pipeline pipe = null;
		try {
			jedis = redisConnectionUtil.getJedis();
			pipe = jedis.pipelined();
			Set<String> keys = map.keySet();
			for (String key : keys) {
				pipe.set(key, map.get(key));
			}
			pipe.sync();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if(pipe!=null){
				try {
					pipe.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(jedis!=null){
				jedis.close();
			}
		}
	}

	/**
	 * Get
	 * 
	 * @param key
	 * @return String
	 */
	public String get(String key) {
		return redisConnectionUtil.getJedis().get(key);
	}
}
