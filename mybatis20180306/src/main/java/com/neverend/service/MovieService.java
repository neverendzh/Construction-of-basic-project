package com.neverend.service;

import com.neverend.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/3/6.
 */

public interface MovieService {

     List<Movie> findByMovieALl();
}