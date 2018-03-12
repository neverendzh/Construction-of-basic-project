package com.neverend.service.impl;

import com.neverend.dao.UserDao;
import com.neverend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/2/25.
 */
@Service
/*@Scope("prototype")
@Lazy*/
public class UserserviceMpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void save() {
        userDao.save();
        System.out.println("service ren ......");
    }
}