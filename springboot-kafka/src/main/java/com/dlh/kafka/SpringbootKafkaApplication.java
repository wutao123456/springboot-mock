package com.dlh.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootKafkaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootKafkaApplication.class, args);
        KafkaSender sender = context.getBean(KafkaSender.class);
        sender.send();
    }
}
