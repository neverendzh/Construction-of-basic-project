package com.neverend.Controller;

import com.neverend.entity.Movie;
import com.neverend.service.MovieService;
import com.neverend.service.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by Administrator on 2018/3/6.
 */
@Controller

public class MovieController {

    @Autowired
    private MovieServiceImpl movieService;
    @GetMapping("/movie")
    public String findByMovie(Model model){
         List<Movie> movieList = movieService.findByMovieALl();
         model.addAttribute("Movie",movieList);
         return "Movie";
    }


}