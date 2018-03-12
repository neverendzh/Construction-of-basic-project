package com.neverend.service;

import com.neverend.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2018/3/10.
 */
public interface Java8New {
    void find();
    String find1();
    List<User> user();
    default User findUser(User user){
        return user;
    }
}
