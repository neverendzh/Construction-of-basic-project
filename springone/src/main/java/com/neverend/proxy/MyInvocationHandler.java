package com.neverend.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/2/25.
 */
public class MyInvocationHandler implements InvocationHandler {


    private Object target;

    public MyInvocationHandler(Object target){
            this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        System.out.println("<<<<<<<<<<");
        Object result =   method.invoke(target,args);
        System.out.println(">>>>>>>>>>>>>");


        return result;
    }
}