package com.dlh.yaml.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/10/27 15:25
 * 通过配置将属性映射到bean(这个地方可映射自定义配置文件)
 */
@Configuration
@PropertySource(value = "classpath:test.yaml")
@ConfigurationProperties(prefix = "com.dlh")
public class TestBean {

    private String project;

    private String packages;

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }
}
