package com.github.archerda.designpattern.proxy;


import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB动态代理Demo；
 *
 * @author archerda
 * @date 2018/04/24
 */
public class CglibMain {

    public static void main(String[] args) {

        /*
        生成代理类的class文件；
         */
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/Archerda/Desktop/java-example/com/sun/proxy");

        /*
        生成Cglib的增强器；
         */
        Enhancer enhancer = new Enhancer();

        /*
        给增强器设置父类；
         */
        enhancer.setSuperclass(TargetClass.class);

        /*
        给增强器设置会拦截器；
         */
        enhancer.setCallback(new Interceptor());

        /*
        使用增强器创建代理类；
         */
        TargetClass target = (TargetClass) enhancer.create();

        /*
        调用代理类方法；
         */
        target.sayHi();
    }

    private static class Interceptor implements MethodInterceptor {

        /**
         *
         * @param o 代理对象，比如：TargetClass$EnhancerByCGLIB$72cfe419
         * @param method 原始方法（要被拦截的方法）；比如：public void com.github.archerda.designpattern.proxy.TargetClass.sayHi()
         * @param objects 参数集；
         * @param methodProxy 代理方法（要触发父类的方法对象）；
         * @return Object
         * @throws Throwable 异常
         */
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("Invoke start");

            /*
            这里不能使用 method#invoke 或者 methodProxy#invoke，否则可能会导致死循环；
             */
            methodProxy.invokeSuper(o, objects);
            System.out.println("Invoke end.");
            return null;
        }
    }
}
