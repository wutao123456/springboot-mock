package com.dlh.kafka;

import lombok.Data;

import java.util.Date;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/11/24 0:32
 */
@Data
public class Message {

    private long id;

    private String msg;

    private Date sendTime;
}
