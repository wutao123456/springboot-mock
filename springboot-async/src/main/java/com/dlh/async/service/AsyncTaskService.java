package com.dlh.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/10/27 21:02
 */
@Component
@Slf4j
public class AsyncTaskService {

    @Async
    public void test1(String id){
        log.info("开始执行 " + id);
        try{
            Thread.sleep(2000);
        }catch (Exception e){

        }
        log.info("look up "+ id);
    }

    @Async
    public void test2(String id){
        log.info("look up "+ id);
    }

    @Async
    public void test3(String id){
        log.info("look up "+ id);
    }
}
