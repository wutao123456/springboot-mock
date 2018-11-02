package com.dlh.springbootamqp.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wutao
 * @date 2018/11/2
 */
@Data
public class User implements Serializable{

    private int id;

    private String name;

    private String password;
}
