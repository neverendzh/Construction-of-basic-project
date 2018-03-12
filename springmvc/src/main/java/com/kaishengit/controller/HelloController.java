package com.kaishengit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zh
 * Created by Administrator on 2017/11/2.
 */
@Controller
public class HelloController {
    //@RequestMapping(value = "/hello",method = {RequestMethod.GET,RequestMethod.POST})//method = RequestMethod.GET )
   // @GetMapping//spring4之后可以使用这样方式注释
    @GetMapping("/hell")
    public String sayHello(){

        System.out.println("hello---springMVC");

        return "hello";
    }

}
