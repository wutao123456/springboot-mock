package com.dlh.springbootamqp.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/11/4 14:42
 */
@Component
public class FanoutProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendFanout(){
        String msg = "测试fanout" + System.currentTimeMillis();
        amqpTemplate.convertAndSend("fanoutExchange","",msg);
    }
}
