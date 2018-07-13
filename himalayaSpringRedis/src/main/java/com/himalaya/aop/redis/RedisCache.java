package com.himalaya.aop.redis;

import javax.annotation.Resource;

import com.himalaya.util.SerializationUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年5月11日 下午4:19:41
* @Description:Redis缓存
 */
public class RedisCache {
    
    @Resource
    private JedisPool jedisPool;
    public JedisPool getJedisPool() {
        return jedisPool;
    }
    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    //从redis缓存中查询，反序列化
    public Object getDataFromRedis(String redisKey){
        //查询
        Jedis jedis = jedisPool.getResource();
        byte[] result = jedis.get(redisKey.getBytes());
        
        //如果查询没有为空
        if(null == result){
            return null;
        }
        
        //查询到了，反序列化
        return SerializationUtil.deSerialize(result);
    }
    
    //将数据库中查询到的数据放入redis
    public void setDataToRedis(String redisKey, Object obj){
        
        //序列化
        byte[] bytes = SerializationUtil.serialize(obj);
        
        //存入redis
        Jedis jedis = jedisPool.getResource();
        String success = jedis.set(redisKey.getBytes(), bytes);
        
        if("OK".equals(success)){
            System.out.println("数据成功保存到redis...");
        }
    }
}