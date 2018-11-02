package com.dlh.springbootamqp.rabbit;

import com.dlh.springbootamqp.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wutao
 * @date 2018/11/2
 */
@Component
public class Producer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String msg = "hello" + System.currentTimeMillis();
        amqpTemplate.convertAndSend("hello",msg);
    }

    public void sendObj(User user){
        System.out.println("发送user "+user.toString());
        amqpTemplate.convertAndSend("hello",user);
    }
}
