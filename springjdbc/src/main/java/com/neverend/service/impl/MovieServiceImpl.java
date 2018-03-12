package com.neverend.service.impl;

import com.neverend.dao.KaoLaDao;
import com.neverend.dao.MovieDao;
import com.neverend.entity.KaoLa;
import com.neverend.entity.Movie;
import com.neverend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/2/26.
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;
    @Override
//    完全符合ACID的隔离级别，确保不会发生脏读，幻读和不可重复读。
//    propagation = Propagation.REQUIRED默认属性
//    readOnly = true 只读事务
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.SERIALIZABLE
    ,propagation = Propagation.REQUIRED,readOnly = true)
    public void save(Movie movie) {
        movieDao.save(movie);
        if(1==1){
            throw new RuntimeException("手动异常");
        }
        movieDao.save(movie);
    }
}