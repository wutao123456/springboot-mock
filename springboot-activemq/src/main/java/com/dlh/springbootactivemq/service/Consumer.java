package com.dlh.springbootactivemq.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/11/1 23:48
 */
@Service
public class Consumer {

    @JmsListener(destination = "wutao_queue1")
    public void receiveMsg(String msg){
        System.out.println("收到消息>>>>>>>>"+msg);
    }
}
