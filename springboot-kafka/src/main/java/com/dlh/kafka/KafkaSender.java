package com.dlh.kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/11/24 0:32
 */
@Component
@Slf4j
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public void send(){
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        log.info("+++++++++++++ message={}",gson.toJson(message));
        kafkaTemplate.send("wutao",gson.toJson(message));
    }

}
