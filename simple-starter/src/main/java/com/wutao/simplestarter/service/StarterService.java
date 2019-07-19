package com.wutao.simplestarter.service;

import org.springframework.util.StringUtils;

/**
 * @author wutao
 * @date 2019/7/19
 */
public class StarterService {

    private String config;

    public StarterService(String config) {
        this.config = config;
    }

    public String[] split(String sperator){
        return StringUtils.split(this.config,sperator);
    }
}
