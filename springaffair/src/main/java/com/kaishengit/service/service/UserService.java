package com.kaishengit.service.service;

import com.kaishengit.entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/10/31.
 */
@Service
public interface UserService {
    void save(User user) throws Exception;
}
