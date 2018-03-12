package com.neverend.service;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.neverend.pojo.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2018/3/4.
 */
@Service
public class MovieService {
    @Autowired
    private RestTemplate restTemplate;

    @Hystrix(cacheKey = "getMovieFallback")
    public Movie getMovie(Integer id) {
        return restTemplate.getForObject("http://MOVIE-SERVICE-PROVIDER/movie/"+id,Movie.class);
    }
    public Movie getMovieFallback(Integer id) {
        return new Movie(-1,null,null);
    }
}