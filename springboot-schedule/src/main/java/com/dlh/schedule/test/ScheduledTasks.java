package com.dlh.schedule.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/10/27 17:12
 */
@Component
@Slf4j
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * fixRate 该属性的含义是上一个调用开始后再次调用的延时（不用等待上一次调用完成）
     */
    @Scheduled(fixedRate = 1000)
    public void test() throws Exception {
        Thread.sleep(2000);
        log.info("This is test");
    }

    /**
     * fixedDelay 该属性的功效与上面的fixedRate则是相反的，
     * 配置了该属性后会等到方法执行完成后延迟配置的时间再次执行该方法。
     */
    @Scheduled(fixedDelay = 1000)
    public void test1() throws InterruptedException {
        Thread.sleep(3000);
        log.info("This is test1");
    }

    /**
     * initialDelay 该属性跟上面的fixedDelay、fixedRate有着密切的关系，为什么这么说呢？
     * 该属性的作用是第一次执行延迟时间，只是做延迟的设定，并不会控制其他逻辑
     */
    @Scheduled(initialDelay = 1000*10,fixedDelay = 1000*2)
    public void test2(){
        log.info("This is test2");
    }
}
