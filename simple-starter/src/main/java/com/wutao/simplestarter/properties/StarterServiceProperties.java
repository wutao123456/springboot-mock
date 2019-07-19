package com.wutao.simplestarter.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author wutao
 * @date 2019/7/19
 */
@ConfigurationProperties("example.service")
public class StarterServiceProperties {

    private String config;

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
}
