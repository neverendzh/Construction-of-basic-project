package com.neverend.controller;

import com.neverend.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/3/4.
 */
@RestController
public class MovieController {
    @GetMapping("/user/{id:\\d+}")
    public User findUser(){
        return new User(10,"张三","JAK");
    }
}