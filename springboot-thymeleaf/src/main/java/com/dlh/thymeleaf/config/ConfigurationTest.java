package com.dlh.thymeleaf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;

/**
 * @author wutao
 * @date 2019/11/25
 */
@Configuration
public class ConfigurationTest {

    @Autowired
    private MessageSource messageSource;
}
