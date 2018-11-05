package com.dlh.springbootactivemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SpringbootActivemqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootActivemqApplication.class, args);
	}
}
