package com.neverend;

import com.neverend.dao.AdminDao;
import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Administrator on 2018/2/25.
 */
@Configuration//表示一个配置类
@ComponentScan //表示从此类开始扫描以下的包
@EnableAspectJAutoProxy //开启基于注解的AOP
public class ApplicationContext {
    @Bean
    public AdminDao adminDao (){
        return new AdminDao();
    }
}