package com.github.archerda.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理Demo；
 *
 * @author archerda
 * @date 2018/01/08
 */
public class JdkMain {

    public static void main(String[] args) {

        /*
        生成$Proxy0的class文件
         */
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        TargetInterface targetInterface = new TargetInterfaceImpl();

        /*
        生成一个代理类，这个代理类签名如下：public final class $Proxy0 extends Proxy implements TargetInterface
        它继承了 Proxy 类（这也是JDK代理不能代理类的原因），并实现了 TargetInterface 接口；
        并且这个类是 final 的，不能被继承；

        类名：$Proxy0；（$Proxy + 自增数字）
        */
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(targetInterface.getClass().getClassLoader(),
                targetInterface.getClass().getInterfaces(), new Handler(targetInterface));

        /*
        调用ProxyHolder的sayHi方法，JVM会把这个方法转交给 InvocationHandler 的 invoke 方法；
        实际的调用方法如下：
        public final void sayHi() throws  {
            try {
                super.h.invoke(this, m3, (Object[])null);
            } catch (RuntimeException | Error var2) {
                throw var2;
            } catch (Throwable var3) {
                throw new UndeclaredThrowableException(var3);
            }
        }
         */
        proxy.sayHi();

    }

    private static class TargetInterfaceImpl implements TargetInterface {

        @Override
        public void sayHi() {
            System.out.println("Hi");
        }
    }

    private static class Handler implements InvocationHandler {

        /**
         * JDK的代理，Handler要持有一个实例的引用；
         */
        private TargetInterface targetInterface;

        public Handler(TargetInterface targetInterface) {
            this.targetInterface = targetInterface;
        }

        /**
         * @param proxy 代理对象实例，比如"@Proxy0"
         * @param method 原始方法（被拦截的方法），比如"public abstract void com.github.archerda.designpattern.proxy.TargetInterface.sayHi()"
         * @param args 参数集（被拦截方法的参数）；
         * @return Object
         * @throws Throwable 异常；
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            System.out.println("Invoke start.");

            // 调用 ProxyInstance 的方法；
            // 注意，这里 invoke 方法的 第一个参数，必须是ProxyInstance，如果是ProxyHolder，将会出现死循环；
            // method.invoke(proxy, args); 死循环，因为JVM会一直委托给该方法；
            method.invoke(targetInterface, args);

            System.out.println("Invoke end.");

            return null;
        }
    }

}
