package com.dlh.springbootamqp.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/11/4 14:44
 */
@Component
public class TopicProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(){
        String msg = "hello" + System.currentTimeMillis();
        System.out.println("发送消息 "+msg);
        amqpTemplate.convertAndSend("topic.wutao","topic.message",msg);
    }

    public void sendMessages(){
        String msg = "测试topic" + System.currentTimeMillis();
        System.out.println("发送消息 "+msg);
        amqpTemplate.convertAndSend("topic.wutao","topic.messages",msg);
    }
}
