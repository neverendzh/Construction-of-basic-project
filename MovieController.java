package com.kaishengit.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.kaishengit.ExlsxInput;
import com.kaishengit.entity.Movie;
import com.kaishengit.service.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2018/3/25.
 */
@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieServiceImpl movieService;


    @GetMapping("/aj")
    public String getmovieajax(Model model){
        List<Movie> movies = movieService.getMovie();
        model.addAttribute(movies);
        return "product/movie";
    }

    @PostMapping("/customer/level")
    @ResponseBody
    public Object getMovie(){
        List<Movie> movies = movieService.getMovie();
        Object toJSON = JSONObject.toJSON(movies);
        return toJSON;
    }

    @RequestMapping("/save")
    @ResponseBody
    public Object saveMovie(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        String originalFilename = file.getOriginalFilename();//原文件名字
        try {
            FileInputStream is = (FileInputStream) file.getInputStream();//获取输入流
            Movie movie = new Movie();
            ExlsxInput.getListObject(movie,is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "01";
    }

}