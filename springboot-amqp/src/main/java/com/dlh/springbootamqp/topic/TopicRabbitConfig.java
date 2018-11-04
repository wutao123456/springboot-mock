package com.dlh.springbootamqp.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/11/4 14:38
 */
@Configuration
public class TopicRabbitConfig {

    @Bean
    public Queue queueMessage(){
        return new Queue("topic.message");
    }

    @Bean
    public Queue queueMessages(){
        return new Queue("topic.messages");
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange("topic.wutao");
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange){
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages,TopicExchange exchange){
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}
