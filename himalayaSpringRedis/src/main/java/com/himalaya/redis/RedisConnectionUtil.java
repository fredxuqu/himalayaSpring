package com.himalaya.redis;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;  

/**
 * @author: xuqu
 * @E-mail: fredxuqu@163.com
 * @version 2018年1月24日 下午3:37:12 Description
 */
@Component("redisConnectionUtil")
public class RedisConnectionUtil {
	
	@Value("${spring.redis.database}")
	private int database;
	
	@Value("${spring.redis.host}")
	private String host;
	
	@Value("${spring.redis.port}")
	private int port;
	
	@Value("${spring.redis.password}")
	private String password;
	
	@Value("${spring.redis.timeout}")
	private int timeout; 
	
	@Value("${spring.redis.maxIdle}")
	private int maxIdle;
	
	@Value("${spring.redis.maxActive}")
	private int maxActive;
	
	@Value("${spring.redis.maxWait}")
	private int maxWait;
	
	@Value("${spring.redis.testOnBorrow}")
	private boolean testOnBorrow;
	
	@Value("${spring.redis.testWhileIdle}")
	private boolean testWhileIdle;

	@Value("${spring.redis.blockWhenExhausted}")
	private boolean blockWhenExhausted;
	
	@Value("${spring.redis.numTestsPerEvictionRun}")
	private int numTestsPerEvictionRun;
	
	@Value("${spring.redis.timeBetweenEvictionRunsMillis}")
	private int timeBetweenEvictionRunsMillis;
			
	@Value("${spring.redis.minEvictableIdleTimeMillis}")
	private int minEvictableIdleTimeMillis;
			
	@Value("${spring.redis.softMinEvictableIdleTimeMillis}")
	private int softMinEvictableIdleTimeMillis;
	
    private static JedisPool jedisPool = null;
    
    /**
     * 初始化Redis连接池
     */
    @PostConstruct
    public synchronized void init(){
    	try {
    		if(jedisPool==null){
	            JedisPoolConfig poolConfig = new JedisPoolConfig();
	            poolConfig.setMaxTotal(maxActive);
	            poolConfig.setMaxIdle(maxIdle);
	            poolConfig.setMaxWaitMillis(maxWait);
	            poolConfig.setTestOnBorrow(testOnBorrow);
	            poolConfig.setTestWhileIdle(testWhileIdle);
	            poolConfig.setBlockWhenExhausted(blockWhenExhausted);
	            poolConfig.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
	            poolConfig.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
	            poolConfig.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
	            poolConfig.setSoftMinEvictableIdleTimeMillis(softMinEvictableIdleTimeMillis);
	            jedisPool = new JedisPool(poolConfig, host, port, timeout, password, database);
    		}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Jedis实例
     * 
     * @return
     */
    public synchronized Jedis getJedis() {
        try {
            if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                return resource;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
