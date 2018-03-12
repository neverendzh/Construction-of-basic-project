package com.neverend.listener;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by Administrator on 2018/2/27.
 */
@Component
public class WeiXinListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
          String mgs =   textMessage.getText();
            System.out.println(mgs);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}