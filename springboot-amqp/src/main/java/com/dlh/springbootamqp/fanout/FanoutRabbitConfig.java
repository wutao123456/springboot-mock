package com.dlh.springbootamqp.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/11/4 14:25
 */
@Configuration
public class FanoutRabbitConfig {

    @Bean
    Queue fanoutQueueA(){
        return new Queue("fanout.A");
    }

    @Bean
    Queue fanoutQueueB(){
        return new Queue("fanout.B");
    }

    @Bean
    Queue fanoutQueueC(){
        return new Queue("fanout.C");
    }

    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingFanoutA(Queue fanoutQueueA, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueueA).to(fanoutExchange);
    }

    @Bean
    Binding bindingFanoutB(Queue fanoutQueueB, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueueB).to(fanoutExchange);
    }

    @Bean
    Binding bindingFanoutC(Queue fanoutQueueC, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueueC).to(fanoutExchange);
    }
}
