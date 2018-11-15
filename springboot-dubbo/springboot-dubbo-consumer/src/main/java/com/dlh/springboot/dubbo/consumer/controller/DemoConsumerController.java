package com.dlh.springboot.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dlh.dubbo.demo.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wutao
 * @date 2018/11/15
 */
@RestController
public class DemoConsumerController {


    @Reference
            (mock = "com.dlh.springboot.dubbo.consumer.DemoServiceMock",
            version = "${demo.service.version}",
            application = "${dubbo.application.id}")
    //url="dubbo:localhost:12345"直联
    private DemoService demoService;

    @RequestMapping(value = "/test")
    public String test(){
        return demoService.getPermissions(1L).toString();
    }
}
