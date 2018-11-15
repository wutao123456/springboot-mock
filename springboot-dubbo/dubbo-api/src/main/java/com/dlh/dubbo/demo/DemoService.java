package com.dlh.dubbo.demo;

import com.dlh.dubbo.model.User;

import java.util.List;

public interface DemoService {

    List<String> getPermissions(Long id);

    User queryUserById(int id);
}
