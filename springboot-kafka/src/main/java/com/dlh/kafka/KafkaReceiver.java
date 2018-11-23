package com.dlh.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/11/24 0:37
 */
@Component
@Slf4j
public class KafkaReceiver {

    @KafkaListener(topics = {"wutao"})
    public void listen(ConsumerRecord<String, String> record){

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if(kafkaMessage.isPresent()){
            Object message = kafkaMessage.get();
            log.info("----------------- record =" + record);
            log.info("------------------ message =" + message);
        }

    }
}
