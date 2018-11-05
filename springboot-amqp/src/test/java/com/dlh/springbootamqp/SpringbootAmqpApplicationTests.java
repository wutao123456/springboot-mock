package com.dlh.springbootamqp;

import com.dlh.springbootamqp.entity.User;
import com.dlh.springbootamqp.fanout.FanoutProducer;
import com.dlh.springbootamqp.hello.Producer;
import com.dlh.springbootamqp.topic.TopicProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAmqpApplicationTests {

	@Autowired
	private Producer producer;

	@Autowired
	private TopicProducer topicProducer;

	@Autowired
	private FanoutProducer fanoutProducer;

	/**
	 * 测试发送消息(字符串)
	 */
	@Test
	public void contextLoads() {
		producer.send();
	}

	/**
	 * 测试发送消息(实体类)
	 */
	@Test
	public void testSendObj(){
		User user = new User();
		user.setId(1);
		user.setName("wutao");
		user.setPassword("123456");
		producer.sendObj(user);
	}

	/**
	 * 测试topic路由(完全匹配)
	 */
	@Test
	public void sendMessage() {
		topicProducer.sendMessage();
	}

	/**
	 * 测试topic路由(模糊匹配)
	 */
	@Test
	public void sendMessages() {
		topicProducer.sendMessages();
	}

	/**
	 * 测试fanout路由(广播)
	 */
	@Test
	public void testFanout() {
		fanoutProducer.sendFanout();
	}

}
