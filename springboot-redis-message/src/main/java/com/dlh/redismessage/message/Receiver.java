package com.dlh.redismessage.message;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/10/27 16:08
 */
@Slf4j
public class Receiver {

    private CountDownLatch latch;

    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiveMessage(String message){
        log.info("Received <" + message + ">");
        latch.countDown();
        log.info(String.valueOf(latch.getCount()));
    }
}
