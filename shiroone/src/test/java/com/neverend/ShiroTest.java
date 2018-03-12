package com.neverend;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/2/27.
 */
public class ShiroTest {

    @Test
    public void shiro(){
        //1. 读取classpath中的shiro.ini配置文件，并创建securityManagerFactory对象
       Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //2. 获取SecurityManager
        SecurityManager securityManager = factory.getInstance();
        //3. 设置SecurityManager(仅设置一次)
        SecurityUtils.setSecurityManager(securityManager);
        //4.获取当前登录的对象
        Subject subject = SecurityUtils.getSubject();
        //5.根据账号和密码进行登录
        UsernamePasswordToken token = new UsernamePasswordToken("jack","123123");

        try {

            subject.login(token);
            System.out.println("登录成功");
        } catch (UnknownAccountException ex) {
            ex.printStackTrace();
            System.out.println("找不到该账号");
        } catch (LockedAccountException ex) {
            System.out.println("账号被冻结异常");
        } catch (IncorrectCredentialsException ex) {
            System.out.println("账号或密码错误异常");
        } catch (AuthenticationException ex) {
            System.out.println("认证异常");
        }

        subject.logout();
    }


    @Test
    public void shiroRealm(){
        //1. 读取classpath中的shiro.ini配置文件，并创建securityManagerFactory对象
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        //2. 获取SecurityManager
        SecurityManager securityManager = factory.getInstance();
        //3. 设置SecurityManager(仅设置一次)
        SecurityUtils.setSecurityManager(securityManager);
        //4.获取当前登录的对象
        Subject subject = SecurityUtils.getSubject();
        //5.根据账号和密码进行登录
        UsernamePasswordToken token = new UsernamePasswordToken("jak","19223");

        try {

            subject.login(token);
            System.out.println("登录成功");
        } catch (UnknownAccountException ex) {
            ex.printStackTrace();
            System.out.println("找不到该账号");
        } catch (LockedAccountException ex) {
            System.out.println("账号被冻结异常");
        } catch (IncorrectCredentialsException ex) {
            System.out.println("账号或密码错误异常");
        } catch (AuthenticationException ex) {
            System.out.println("认证异常");
        }

        subject.logout();
    }

    @Test
    public void shiroRealmRose(){
        //1. 读取classpath中的shiro.ini配置文件，并创建securityManagerFactory对象
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-roles.ini");
        //2. 获取SecurityManager
        SecurityManager securityManager = factory.getInstance();
        //3. 设置SecurityManager(仅设置一次)
        SecurityUtils.setSecurityManager(securityManager);
        //4.获取当前登录的对象
        Subject subject = SecurityUtils.getSubject();
        //5.根据账号和密码进行登录
        UsernamePasswordToken token = new UsernamePasswordToken("tom","234");

        try {

            subject.login(token);
            System.out.println("登录成功");
           boolean b =  subject.hasRole("admin");
           boolean b1 = subject.hasRole("hr");
           boolean b2 = subject.hasAllRoles(Arrays.asList("admin","ceo"));
           boolean [] b3 = subject.hasRoles(Arrays.asList("admin","ceo","hr","cio"));
           for(boolean b4 : b3){
               System.out.println("b3"+b4);
           }
            System.out.println("b2"+b2);

//             如果没有，则抛异常
//            subject.checkRole("kk");

            System.out.println("is admin"+b +"----is hr" +b1);



//            ------------------------------ 用户具有的权限
            boolean b4  = subject.isPermitted("user:add");
            System.out.println("user:add?"+b4);
        } catch (UnknownAccountException ex) {
            ex.printStackTrace();
            System.out.println("找不到该账号");
        } catch (LockedAccountException ex) {
            System.out.println("账号被冻结异常");
        } catch (IncorrectCredentialsException ex) {
            System.out.println("账号或密码错误异常");
        } catch (AuthenticationException ex) {
            System.out.println("认证异常");
        }

        subject.logout();
    }


}