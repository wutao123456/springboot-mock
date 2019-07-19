package com.wutao.simplestarter.config;

import com.wutao.simplestarter.properties.StarterServiceProperties;
import com.wutao.simplestarter.service.StarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wutao
 * @date 2019/7/19
 */
@Configuration
@ConditionalOnClass(StarterService.class)
@EnableConfigurationProperties(StarterServiceProperties.class)
public class StarterAutoConfigure {

    @Autowired
    private StarterServiceProperties properties;

    @Bean
    @ConditionalOnMissingBean(StarterService.class)
    @ConditionalOnProperty(value = "example.service",prefix = "enabled",matchIfMissing = true)
    StarterService starterService(){
        return new StarterService(properties.getConfig());
    }
}
