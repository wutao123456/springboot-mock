package com.dlh.wutao.controller;

import com.dlh.wutao.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/10/23 20:34
 */
@Controller
@Slf4j
public class Test {

    @RequestMapping(value = "/")
    public String test(){
        log.info("log test");
        return "hello springboot";
    }

    @RequestMapping(value = "/index")
    public String index(ModelMap map){
        map.put("host","www.baidu.com");
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }
}
