package com.dlh.mybatis.test;

import com.dlh.mybatis.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/10/27 0:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestCache {

    @Autowired
    private UserService userService;

    @Test
    public void test() throws Exception {

        userService.selectOne(13);
    }
}
