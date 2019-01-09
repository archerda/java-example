package com.github.archerda.spring.ioc.beanwire.config;

import com.github.archerda.spring.ioc.beanwire.SgtPeppers;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Create by archerda on 2017/11/19.
 */
@Configuration
@ComponentScan(basePackageClasses = SgtPeppers.class)
public class JavaConfig {
}
