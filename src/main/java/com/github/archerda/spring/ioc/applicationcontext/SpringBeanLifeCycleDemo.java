package com.github.archerda.spring.ioc.applicationcontext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * Spring生命周期Demo
 *
 * @author archerda
 * @date 2018/8/7
 */
public class SpringBeanLifeCycleDemo implements BeanNameAware, BeanFactoryAware, ApplicationContextAware,
        InitializingBean {

    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext applicationContext;
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationcontext/" +
                "springBeanLifeCycleDemoTest.xml");

        applicationContext.start();

        SpringBeanLifeCycleDemo demo = (SpringBeanLifeCycleDemo) applicationContext.getBean("springBeanLifeCycleDemo");

        System.out.println(demo);
    }

    public SpringBeanLifeCycleDemo() {
        System.out.println("constructor");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    public void init() {
        System.out.println("init method");
    }
}
