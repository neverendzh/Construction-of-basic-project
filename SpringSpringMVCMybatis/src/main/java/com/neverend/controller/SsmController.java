package com.neverend.controller;

import com.github.pagehelper.PageInfo;
import com.neverend.entity.Kaola;
import com.neverend.service.impl.KaoLaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/2/26.
 */
@Controller
public class SsmController {
    @Autowired
    private KaoLaServiceImpl kaoLaService;

    @GetMapping("/hello/{id:\\d+}")
    @ResponseBody
    public Kaola save(@PathVariable int id){

        System.out.println(id);
        Kaola kaola = kaoLaService.findfById(id);
        return kaola;
    }

    @GetMapping("/kaola")
    public String  kaolas(@RequestParam(name = "p",required = false,defaultValue = "1") Integer page, Model model){
        PageInfo<Kaola> kaolaPageInfo =  kaoLaService.findpage(page);
        model.addAttribute("page",kaolaPageInfo);
        model.addAttribute("placeList",kaoLaService.findProductPlaceList());
        model.addAttribute("typeList",kaoLaService.findAllType());
        return "product/list";
    }
}