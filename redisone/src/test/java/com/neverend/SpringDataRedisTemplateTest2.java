package com.neverend;

import com.neverend.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2018/2/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-redis.xml")
public class SpringDataRedisTemplateTest2 {

   private RedisTemplate<String ,User> redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.redisTemplate.setKeySerializer(new StringRedisSerializer());
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
//        this.redisTemplate.setValueSerializer(new StringRedisSerializer());
    }

    @Test
    public void saveRedisTemplate(){
        User user = new User(1002,"下栗子","123","河南");
        redisTemplate.opsForValue().set("user:1002", user);
    }

    @Test
    public void getRedisTemplate(){
       User s = redisTemplate.opsForValue().get("user:1002");
        System.out.println(s);
    }

}