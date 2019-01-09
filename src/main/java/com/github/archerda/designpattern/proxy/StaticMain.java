package com.github.archerda.designpattern.proxy;

/**
 * @author archerda
 */
public class StaticMain {

    public static void main(String[] args) {
        TargetInterface targetInterface = new TargetInterfaceImpl();

        TargetInterface target = new ProxyClass(targetInterface);

        // Client
        target.sayHi();
    }

    private static class TargetInterfaceImpl implements TargetInterface {

        @Override
        public void sayHi() {
            System.out.println("Hi");
        }
    }

    public static class ProxyClass implements TargetInterface {

        // 存储真实对象
        private TargetInterface targetInterface;

        public ProxyClass(TargetInterface targetInterface) {
            this.targetInterface = targetInterface;
        }

        @Override
        public void sayHi() {
            System.out.println("Invoke start.");
            targetInterface.sayHi();
            System.out.println("Invoke end.");
        }
    }
}
