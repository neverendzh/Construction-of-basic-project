package com.neverend.service;

import com.neverend.entity.KaoLa;
import com.neverend.entity.Movie;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/2/26.
 */
@Service
public interface MovieService {

     void save(Movie movie);
}