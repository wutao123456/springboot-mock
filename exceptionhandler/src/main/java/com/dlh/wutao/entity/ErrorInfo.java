package com.dlh.wutao.entity;

import lombok.Data;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/10/23 21:47
 */
@Data
public class ErrorInfo<T> {

    private Integer code;

    private String message;

    private String url;

    private T data;
}
