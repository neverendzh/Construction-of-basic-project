package com.neverend;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import redis.clients.jedis.BinaryJedis;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * Created by Administrator on 2018/2/28.
 */
public class RedisTest  {

    @Test
    public void redis(){
        Jedis jedis = new Jedis("42.92.229.422",6379);
        jedis.auth("password");

        jedis.close();
        System.out.println();

    }


    @Test
    public void redisPool(){
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(5);
        JedisPool jedisPool = new JedisPool("42.92.229.422",6379);
        try(Jedis jedis = jedisPool.getResource();){
            jedis.auth("password");
            jedis.set("username","张收纳");
            String uaername = jedis.get("username");
            System.out.println(uaername);
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }
}