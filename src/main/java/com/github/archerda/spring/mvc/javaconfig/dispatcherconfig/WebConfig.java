package com.github.archerda.spring.mvc.javaconfig.dispatcherconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Create by archerda on 2017/11/23.
 */
@Configuration
@EnableWebMvc // 启用SpringMVC
@ComponentScan("com.github.archerda.spring.mvc.javaconfig.dispatcherconfig") // 启用组件扫描
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        // 配置JSP视图解析器
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);

        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        /*
        通过调用enable方法，我们要求分发器将静态资源的请求转发到Servlet容器中默认的Servlet上，而不是使用分发器本身来处理此类请求；
         */
        configurer.enable();
    }
}
