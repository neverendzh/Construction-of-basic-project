package com.neverend.dao;

import com.neverend.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/2/26.
 */
@Repository
public class MovieDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Movie movie){
        String sql = "insert into movie (name,password) values (?,?)";
       int insert =  jdbcTemplate.update(sql,movie.getName(),movie.getPassword());
        System.out.println(insert);
    }
}