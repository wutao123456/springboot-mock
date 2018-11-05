package com.dlh.springbootamqp.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/11/4 14:44
 */
@Component
public class TopicConsumer {


    @RabbitListener(queues = "topic.message")
    @RabbitHandler
    public void receiveTopic(String msg){
        System.out.println("我负责监听topic1");
        System.out.println("Receiver message: "+msg);
    }

    @RabbitListener(queues = "topic.messages")
    @RabbitHandler
    public void receiveTopicMessages(String msg){
        System.err.println("我负责监听topic2");
        System.err.println("Receiver messages: "+msg);
    }
}
