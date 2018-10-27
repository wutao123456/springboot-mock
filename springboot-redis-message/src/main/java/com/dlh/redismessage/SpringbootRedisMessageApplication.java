package com.dlh.redismessage;

import com.dlh.redismessage.message.Receiver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
@Slf4j
public class SpringbootRedisMessageApplication {

	@Bean
	RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,MessageListenerAdapter adapter){
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.addMessageListener(adapter,new PatternTopic("chat"));
		return container;
	}

	@Bean
	MessageListenerAdapter adapter(Receiver receiver){
		return new MessageListenerAdapter(receiver,"receiveMessage");
	}

	@Bean
	CountDownLatch countDownLatch(){
		return new CountDownLatch(1);
	}

	@Bean
	Receiver receiver(CountDownLatch latch){
		return new Receiver(latch);
	}

	@Bean
	StringRedisTemplate template(RedisConnectionFactory connectionFactory){
		return new StringRedisTemplate(connectionFactory);
	}

	public static void main(String[] args) throws Exception{
		ApplicationContext ctx = SpringApplication.run(SpringbootRedisMessageApplication.class, args);
		StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
		CountDownLatch latch = ctx.getBean(CountDownLatch.class);
		log.info("....sending message");
		template.convertAndSend("chat","hello from redis");
		latch.await();
		System.exit(0);
	}
}
