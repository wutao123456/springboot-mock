package com.dlh.springbootamqp.hello;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wutao
 * @date 2018/11/2
 */
@Configuration
public class RabbitmqConfig {

    @Bean
    public Queue queue(){
        return new Queue("hello");
    }

    @Bean
    public Queue queue1(){
        return new Queue("wutao_queue");
    }


}
