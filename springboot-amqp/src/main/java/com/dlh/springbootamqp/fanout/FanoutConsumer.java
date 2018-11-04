package com.dlh.springbootamqp.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/11/4 14:43
 */
@Component
public class FanoutConsumer {

    @RabbitListener(queues = {"fanout.A","fanout.B","fanout.C","fanout.queue"})
    @RabbitHandler
    public void receiveFanout(String msg){
        System.err.println("我负责监听FANOUT");
        System.err.println("Receiver fanout: "+msg);
    }
}
