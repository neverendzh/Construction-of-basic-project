package com.neverend.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by Administrator on 2018/2/27.
 */
@Component
public class SpringListenerPubSub implements MessageListener{



    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("pubsub"+textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}