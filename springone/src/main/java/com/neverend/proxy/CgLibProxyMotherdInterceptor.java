package com.neverend.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/2/25.
 */
public class CgLibProxyMotherdInterceptor  implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("----------");

       Object result =  methodProxy.invokeSuper(o,objects);

        System.out.println("__________");

        return result;
    }
}