package com.dlh.async.controller;

import com.dlh.async.service.AsyncTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/10/27 21:05
 */
@RestController
@RequestMapping(value = "async")
@Slf4j
public class TestController {

    @Autowired
    private AsyncTaskService asyncTaskService;

    @RequestMapping(value = "test")
    public String test(){
        for (int i = 1; i <= 10; i++) {
            asyncTaskService.test1(String.valueOf(i));
        }
//        asyncTaskService.test1("1");
//        asyncTaskService.test2("2");
//        asyncTaskService.test3("3");
        return "test";
    }
}
