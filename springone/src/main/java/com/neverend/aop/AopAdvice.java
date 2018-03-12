package com.neverend.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by Administrator on 2018/2/25.
 */
public class AopAdvice {

    public void beforeAdvice() {
        System.out.println("前置通知");
    }
    public void afterAdvice() {
        System.out.println("后置通知");
    }
    public void exceptionAdvice(Exception ex) {
        System.out.println("异常通知"+ex.getMessage());
    }
    public void finallyAdvice() {
        System.out.println("最终通知");
    }

    public void aroundAdvice(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("--before--");
            Object result = joinPoint.proceed(); //目标对象方法的执行
            System.out.println("--after--");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("--exception--");
        } finally {
            System.out.println("--finally--");
        }
    }

}