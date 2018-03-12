package com.neverend.controller;

import com.neverend.pojo.Movie;
import com.neverend.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/3/4.
 */
@RestController
public class UserController {
    @GetMapping("/movie/{id:\\d+}")
    public Movie findMvie(){
        return new Movie(20,"西游记","AAA");

    }
}