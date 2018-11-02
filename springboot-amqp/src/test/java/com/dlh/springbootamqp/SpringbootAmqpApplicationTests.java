package com.dlh.springbootamqp;

import com.dlh.springbootamqp.entity.User;
import com.dlh.springbootamqp.rabbit.Producer;
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

	@Test
	public void contextLoads() {
		producer.send();
	}

	@Test
	public void testSendObj(){
		User user = new User();
		user.setId(1);
		user.setName("wutao");
		user.setPassword("123456");
		producer.sendObj(user);
	}

}
