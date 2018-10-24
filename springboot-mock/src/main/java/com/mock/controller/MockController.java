package com.mock.controller;

import com.mock.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by wutao on 2018/10/24
 */
@RestController
@RequestMapping(value = "mock")
public class MockController {

    @RequestMapping(value = "get",method = RequestMethod.GET)
    public String get(String param){
        return "get请求参数:"+param;
    }

    @RequestMapping(value = "post",method = RequestMethod.POST)
    public String post(@RequestBody User user){
        return "post请求参数:"+user;
    }
}
