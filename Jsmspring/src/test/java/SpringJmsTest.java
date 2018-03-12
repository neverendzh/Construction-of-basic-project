import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * Created by Administrator on 2018/2/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringJmsTest {

    @Autowired
    private JmsTemplate template;
    @Test
    public void send(){
        template.send("spring-queue",new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
              TextMessage textMessage =  session.createTextMessage("spring-jms-send");
                return textMessage;
            }
        });
    }


    @Test
    public void sendTopic(){
        ActiveMQTopic activeMQTopic = new ActiveMQTopic("Spring-Topic");
        template.send(activeMQTopic,new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage =  session.createTextMessage("spring-jms-send_topic");
                return textMessage;
            }
        });
    }


    @Test
    public void Pubsub(){
        ActiveMQTopic activeMQTopic = new ActiveMQTopic("PubSub-queue");
        template.send(activeMQTopic,new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage =  session.createTextMessage("spring-jms-PubSub-queue");
                return textMessage;
            }
        });
    }
}