package com.dlh.springbootdubboprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboProviderApplication.class, args);
//        new SpringApplicationBuilder(SpringbootDubboProviderApplication.class)
//                .web(WebApplicationType.NONE)
//                .run(args);
    }
}
