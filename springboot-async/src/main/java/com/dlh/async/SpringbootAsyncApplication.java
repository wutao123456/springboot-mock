package com.dlh.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 开启异步任务 EnableAsync
 */
@SpringBootApplication
public class SpringbootAsyncApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAsyncApplication.class, args);
	}
}
