package com.neverend;

import com.alibaba.fastjson.JSON;
import com.neverend.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Administrator on 2018/2/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-redis.xml")
public class SpringJedsTest {
        @Autowired
    private JedisPool jedisPool;
    @Test
    public void saveRedis(){
        Jedis jedis = jedisPool.getResource();
        jedis.auth("password");
        jedis.set("name","JJ");
        String name = jedis.get("name");
        System.out.println(name);
        jedis.close();
        jedisPool.destroy();
    }

    @Test
    public void saveUser(){
        User user = new User(1001,"张三","123456","上海");
        String userJson =  JSON.toJSONString(user);
        Jedis jedis = jedisPool.getResource();
        jedis.auth("password");
        jedis.set("user:1001",userJson);
        jedis.close();
    }

    @Test
    public void getUser(){
        Jedis jedis = jedisPool.getResource();
        jedis.auth("password");
        String user = jedis.get("user:1001");
        User user1 = JSON.parseObject(user,User.class);
        System.out.println(user1);
    }

}