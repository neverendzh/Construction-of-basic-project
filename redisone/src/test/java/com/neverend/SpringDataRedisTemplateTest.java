package com.neverend;

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
public class SpringDataRedisTemplateTest {

   private RedisTemplate<String ,String> redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.redisTemplate.setKeySerializer(new StringRedisSerializer());
//        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Object>());
        this.redisTemplate.setValueSerializer(new StringRedisSerializer());
    }

    @Test
    public void saveRedisTemplate(){
        redisTemplate.opsForValue().set("adress","河南");
    }

    @Test
    public void getRedisTemplate(){
       String s = redisTemplate.opsForValue().get("adress");
        System.out.println(s);
    }

}