package com.github.archerda.spring.mvc.javaconfig.dispatcherconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Create by archerda on 2017/11/23.
 */
@Configuration
@ComponentScan(value = "com.github.archerda.spring.mvc.javaconfig.dispatcherconfig",
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        })
public class RootConfig {
}
