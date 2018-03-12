package com.neverend.client;

import com.neverend.pojo.Movie;
import com.neverend.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Administrator on 2018/3/4.
 */
@FeignClient(name = "MOVIE-SERVICE-PROVIDER")
public interface MovieServiceClient {

    @GetMapping("/user/{id}")
    User findBymovie(@PathVariable("id") Integer id);
}

