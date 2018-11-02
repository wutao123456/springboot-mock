package com.dlh.springbootamqp.config;

import org.springframework.amqp.core.Queue;
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
}
