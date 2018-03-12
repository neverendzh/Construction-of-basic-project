package com.neverend.controller;

import com.neverend.client.MovieServiceClient;
import com.neverend.pojo.Movie;
import com.neverend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
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
    private RestTemplate restTemplate;

    @Autowired
    private MovieServiceClient movieServiceClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/movie/{id:\\d+}")
    public Movie findMovie(@PathVariable Integer id){
        String url =  "http://MOVIE-SERVICE-PROVIDER/movie/"+id;
        return restTemplate.getForObject(url,Movie.class);

    }

    @GetMapping("/user/{id:\\d+}")
    public User findUser(@PathVariable Integer id){
      return   movieServiceClient.findBymovie(id);
    }
}