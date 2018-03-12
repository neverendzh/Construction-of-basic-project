package com.neverend.controller;

import com.neverend.pojo.Movie;
import com.neverend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancedRetryContext;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2018/3/4.
 */
@RestController
public class MovieController {
    @Autowired
    private MovieService restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/movie/{id:\\d+}")
    public Movie findMovie(@PathVariable Integer id){
        return restTemplate.getMovie(id);

    }
}