package com.neverend.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 基于注解的监听器
 * Created by Administrator on 2018/2/27.
 */
@Component
public class SpringListener {

    @JmsListener(destination = "spring-queue",containerFactory = "jmsListenerContainerFactory")
    public void doSomeThing(String message){
        System.out.println("++++"+message);
    }

    @JmsListener(destination = "Spring-Topic",containerFactory = "jmsTopicListenerContainerFactory")
    public void doSomeThingTopic(String message){
        System.out.println("++++"+message);
    }
}