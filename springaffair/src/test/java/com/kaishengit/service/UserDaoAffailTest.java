package com.kaishengit.service;

import com.kaishengit.Application;
import com.kaishengit.entity.User;
import com.kaishengit.service.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/10/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)//(locations = "classpath:applicationContext.xml")
public class UserDaoAffailTest {
    @Autowired
    private UserService userService;
    @Test
    public void saveJdbc() throws Exception {
        User user = new User();
        user.setUserName("googoo");
        user.setAddress("香港");
        user.setDeptId(100);
        user.setPasswords("1111");
        userService.save(user);

    }
}
