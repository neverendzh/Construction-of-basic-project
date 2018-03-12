package com.neverend.service.impl;

import com.neverend.entity.Movie;
import com.neverend.mapper.MovieMapper;
import com.neverend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/3/6.
 */
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public List<Movie> findByMovieALl() {
        return   movieMapper.find();
    }
}