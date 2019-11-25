package com.dlh.thymeleaf.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wutao
 * @date 2019/11/25
 */
@Data
public class User implements Serializable {
    private Long uid ;
    private String name ;
    private Integer age ;
    private Date birthday ;
    private Double salary ;
}
