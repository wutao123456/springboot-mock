package com.dlh.log;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/11/6 23:39
 */
@RestController
public class HelloController {

    private static Logger logger = Logger.getLogger(HelloController.class);

    @RequestMapping("hello")
    public String hello(){
        logger.debug("hello world,debug");
        logger.info("hello world,info");
        logger.warn("hello world,warn");
        logger.error("hello world,error");
        return "hello world";
    }
}
