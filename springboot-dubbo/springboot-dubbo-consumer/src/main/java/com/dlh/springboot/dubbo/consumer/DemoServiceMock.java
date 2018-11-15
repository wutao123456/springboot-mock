package com.dlh.springboot.dubbo.consumer;

import com.dlh.dubbo.demo.DemoService;
import com.dlh.dubbo.model.User;

import java.util.Arrays;
import java.util.List;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/11/15 21:22
 * 服务容错
 */
public class DemoServiceMock implements DemoService {

    @Override
    public List<String> getPermissions(Long id) {
        String[] exception = {"服务连接不上"};
        return Arrays.asList(exception);
    }

    @Override
    public User queryUserById(int id) {
        return null;
    }
}
