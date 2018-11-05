package com.dlh.springbootactivemq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/11/1 23:45
 */
@Service
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMsg(Destination destination,String msg){
        jmsMessagingTemplate.convertAndSend(destination,msg);
    }
}
