package com.neverend.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/2/25.
 */
@Component //交给Spring管理
@Aspect  //告诉Spring容器这是一个通知类
public class AopAdvice {

    @Pointcut("execution(* com.neverend.service..*.*(..))")
    public void pointcut(){

    }
   /* @Before("pointcut()")
    public void beforeAdvice() {

        System.out.println("前置通知");

    }


    @AfterReturning(pointcut = "pointcut()",returning = "result")
    public void afterAdvice(Object result) {
        System.out.println("后置通知");
    }

    @AfterThrowing(pointcut = "pointcut()",throwing = "ex")
    public void exceptionAdvice(Exception ex) {
        System.out.println("异常通知"+ex.getMessage());
    }

    @After("pointcut()")
    public void finallyAdvice() {
        System.out.println("最终通知");

    }
*/
   @Around("pointcut()")
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