package com.dlh.redismessage.testrest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/10/27 16:39
 */
@RestController
@RequestMapping(value = "rest")
@Slf4j
public class RestControllerTest {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "test")
    public String test(){
        String quote = restTemplate.getForObject(
                "http://gturnquist-quoters.cfapps.io/api/random", String.class);
        log.info(quote.toString());
        return "test";
    }
}
