package com.dlh.springbootactivemq;

import com.dlh.springbootactivemq.service.Producer;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootActivemqApplicationTests {

	@Autowired
	private Producer producer;

	@Test
	public void contextLoads() {
		ActiveMQQueue queue = new ActiveMQQueue("wutao_queue1");
		producer.sendMsg(queue,"test 你好");
	}

}
