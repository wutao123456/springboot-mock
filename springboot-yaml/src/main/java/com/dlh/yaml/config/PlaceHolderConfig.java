package com.dlh.yaml.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

/**
 * create by wutao on 2018/10/25
 * 初始化yaml配置文件
 */
@Configuration
public class PlaceHolderConfig {

    @Bean
    public PropertySourcesPlaceholderConfigurer configurer(){
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        factoryBean.setResources(new FileSystemResource("src/main/resources/test.yaml"));
        configurer.setProperties(factoryBean.getObject());
        return configurer;
    }
}
