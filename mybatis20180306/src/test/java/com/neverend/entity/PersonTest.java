package com.neverend.entity;

import org.junit.Test;

import javax.jws.WebService;
import javax.swing.*;
import java.lang.*;
import java.lang.String;
import java.sql.SQLDataException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2018/3/8.
 */
public class PersonTest extends Thread {

    @Override
    public void run() {
        super.run();
    }

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        Map<Integer,User> map = new HashMap<>();
        map.put(1,new User(12,"jak"));
        map.put(1,new User(10,"jak"));
        map.put(1,new User(122,"jak"));
        System.out.println(map);

    }

}