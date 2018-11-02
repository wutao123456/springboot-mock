package com.dlh.springbootamqp.rabbit;

import com.dlh.springbootamqp.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wutao
 * @date 2018/11/2
 */
@Component
@RabbitListener(queues = "hello")
public class Consumer {

    @RabbitHandler
    public void receive(String message){
        System.out.println("收到消息"+message);
    }

    @RabbitHandler
    public void receive(User user){
        System.err.println("Receiver object: "+user.toString());
    }
}
