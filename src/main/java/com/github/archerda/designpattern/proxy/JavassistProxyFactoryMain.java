package com.github.archerda.designpattern.proxy;

import javassist.util.proxy.MethodFilter;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.Proxy;
import javassist.util.proxy.ProxyFactory;

import java.lang.reflect.Method;

/**
 * Javassist动态代理: 采用 javassist.util.proxy.ProxyFactory 来创建代理(非字节码方式);
 *
 * @author archerda
 * @date 2018/9/4
 */
public class JavassistProxyFactoryMain {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        TargetClass proxy = (TargetClass) getProxy(TargetClass.class);

        proxy.sayHi();

    }

    private static Object getProxy(Class<?> type) throws IllegalAccessException, InstantiationException {

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setSuperclass(type);
        proxyFactory.setFilter(new MethodFilter() {
            @Override
            public boolean isHandled(Method m) {
                return !m.getName().equals("finalize");
            }
        });

        Class c = proxyFactory.createClass();
        MethodHandler handler = new MethodHandler() {
            @Override
            public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
                System.out.println("Method name:" + thisMethod.getName() + " exec");
                // 基于反射;
                return proceed.invoke(self, args);
            }
        };

        Object proxy = c.newInstance();
        ((Proxy) proxy).setHandler(handler);

        return proxy;
    }
}
