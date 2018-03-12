package com.neverend.controllrt;

import com.neverend.entity.User;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2018/2/26.
 */
@Controller
public class HelloController {
//    @RequestMapping(value = "/hello",method = {RequestMethod.GET,RequestMethod.POST})
    @GetMapping("/hello")
    public String sayHell(){
        System.out.println("hello mvc");
        return "hello";
    }

    @GetMapping("/movie/{id:\\d+}")
    public String mivie(@PathVariable Integer id){
        System.out.println(id);
        return "hello";
    }

    /**
     * /blog?id=100&tag=200
     * /blog?id=100
     * @param id
     * @return
     */
    @GetMapping("/blog")
    public String blog(Integer id, @RequestParam(name = "tag",required = false,defaultValue = "1") Integer tagId, Model model){
        model.addAttribute("id",id);
        model.addAttribute("tag",tagId);
        System.out.println("id-->"+id+"tag--->"+tagId);
        return "hello";
    }

    @GetMapping("find/{classname}/user/{id:\\d+}")
    public String findByClass(@PathVariable String classname,@PathVariable String id,Model model){

        model.addAttribute("classname",classname);
        model.addAttribute("id",id);
        System.out.println("classname"+classname+"id"+id);

        return "hello";
    }

    @GetMapping("/save")
    public String save(){
        return "save";
    }

    @PostMapping("/save")
    public String save(User user, Model model, MultipartFile photo, RedirectAttributes redirectAttributes){
        model.addAttribute("username",user.getUsername());
        model.addAttribute("password",user.getPassword());
//        System.out.println("username"+user.getUsername()+"--"+"password"+user.getPassword());
        if(!photo.isEmpty()){
            System.out.println(photo.getOriginalFilename());
            System.out.println(photo.getSize());
            try {
                IOUtils.copy(photo.getInputStream(),new FileOutputStream("E:/temp/"+photo.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        redirectAttributes.addFlashAttribute("message","资料已上传");
        return "redirect:/save";
    }


    @GetMapping("/user")
    @ResponseBody//直接转换成Json
    public User getuser(){
        User user = new User();
        user.setId(23);
        user.setPassword("123");
        user.setUsername("jiba");
        return user;
    }
}