package com.dlh.springbootmongodb;

import com.dlh.springbootmongodb.entity.User;
import com.dlh.springbootmongodb.service.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootMongodbApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void contextLoads() {
		userRepository.insert(new User(1,"test1"));
		userRepository.insert(new User(2,"test2"));

//		Optional<User> user=  userRepository.findById(1L);
//		User userInfo = user.get();
//		log.info(userInfo.toString());
//
//		User user1 = userRepository.findUserByName("test2");
//		log.info(user1.toString());
//
//		userRepository.deleteById(1L);
//		Assert.assertEquals(1,userRepository.findAll().size());

	}

}
