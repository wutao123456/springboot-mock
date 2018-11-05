package com.dlh.springbootamqp.hello;

import com.dlh.springbootamqp.entity.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wutao
 * @date 2018/11/2
 */
@Component
public class Consumer {

    @RabbitListener(queues = "hello")
    @RabbitHandler
    public void receive(Message message){
        byte[] msg = message.getBody();
        if(msg.length >0){
            System.out.println("收到消息"+new String(msg));
        }
//        System.out.println("收到消息"+message);
    }

    @RabbitListener(queues = "wutao_queue")
    @RabbitHandler
    public void receive(User user){
        System.err.println("Receiver object: "+user.toString());
    }


}
