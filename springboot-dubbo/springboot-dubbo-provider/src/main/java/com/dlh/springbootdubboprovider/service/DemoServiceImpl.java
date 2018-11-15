package com.dlh.springbootdubboprovider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.dlh.dubbo.demo.DemoService;
import com.dlh.dubbo.model.User;

import java.util.Arrays;
import java.util.List;

/**
 * @author wutao
 * @date 2018/11/15
 */
@Service(version = "${demo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class DemoServiceImpl implements DemoService {
    @Override
    public List<String> getPermissions(Long id) {
        String[] strArr = {"hello","world"};
         return Arrays.asList(strArr);
    }

    @Override
    public User queryUserById(int id) {
        return null;
    }
}
