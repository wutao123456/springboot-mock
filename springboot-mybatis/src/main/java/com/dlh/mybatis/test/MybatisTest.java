package com.dlh.mybatis.test;

import com.dlh.mybatis.dao.UserMapper;
import com.dlh.mybatis.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/10/24 20:55
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MybatisTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        try {
            User user = new User();
            user.setName("wutao");
            user.setId(15);
            int result = userMapper.addUser(user);
            log.info("插入数据成功");
        } catch (Exception e) {
            log.error("插入数据失败");
        }


        try {

            User user = userMapper.selectOne(15);
            if(user!=null){
                log.info(String.format("查询到一个User: %s", user));
            }
        } catch (Exception e) {
            log.error("查询一个User失败");
        }

        try {
            int result = userMapper.deleteUser(15);
            if(result > 0){
                log.info("删除User成功");
            }
        } catch (Exception e) {
            log.error("删除User失败");
        }
    }
}
