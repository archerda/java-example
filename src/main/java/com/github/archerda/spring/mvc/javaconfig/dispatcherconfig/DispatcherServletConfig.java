// package com.github.archerda.spring.mvc.javaconfig.dispatcherconfig;
//
// import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
// /**
//  * java方式配置Servlet分发器
//  *
//  * 如果按照这种方式配置DispatcherServlet，而不是使用web.xml
//  * 的话，那唯一问题在于它只能部署到支持Servlet 3.0的服务器中才能
//  * 正常工作，如Tomcat 7或更高版本。Servlet 3.0规范在2009年12月份就
//  * 发布了，因此很有可能你会将应用部署到支持Servlet 3.0的Servlet容
//  * 器之中
//
//  * Create by archerda on 2017/11/23.
//  */
// public class DispatcherServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//     /*
//    将DispatcherServlet映射到"/", 这表示它会是应用的默认Servlet，它会处理进入应用的所有请求。
//    */
//     @Override
//     protected String[] getServletMappings() {
//         return new String[]{"/"};
//     }
//
//     /*
//     返回的带有@Configuration注解的类将会用来配置ContextLoaderListener创建的应用上下文中的bean。
//      */
//     @Override
//     protected Class<?>[] getRootConfigClasses() {
//         return new Class[]{RootConfig.class};
//     }
//
//     /*
//     返回的带有@Configuration注解的类将会用来定义DispatcherServlet应用上下文中的bean
//      */
//     @Override
//     protected Class<?>[] getServletConfigClasses() {
//         return new Class[]{WebConfig.class};
//     }
// }
