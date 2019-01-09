package com.github.archerda.designpattern.singleton.destory.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 利用实例化标志位解决反射破坏单例的问题
 *
 * Create by archerda on 2017/11/12.
 */
public class SolutionSingleton {

    private static SolutionSingleton instance;
    private static boolean isInit = false;

    private SolutionSingleton() {
       synchronized (SolutionSingleton.class) {
            if (isInit) {
                throw new RuntimeException("Singleton has been initialized.");
            } else {
                isInit = true;
            }
        }
    }

    public static synchronized SolutionSingleton getInstance() {
        if (instance == null) {
            instance = new SolutionSingleton();
        }
        return instance;
    }

    public static void main3(String[] args) throws Exception {

        // 常规方法获取实例
        SolutionSingleton commonSolutionSingleton = SolutionSingleton.getInstance();

        // 通过反射获取实例：这里会抛异常，因为只允许实例化一次；
        Constructor constructor = SolutionSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SolutionSingleton reflectionSolutionSingleton = (SolutionSingleton) constructor.newInstance();

        // 这里不会执行到
        System.out.println(reflectionSolutionSingleton == commonSolutionSingleton);
    }

    public static void main(String[] args) throws Exception {

        // 常规方法获取实例
        SolutionSingleton commonSolutionSingleton = SolutionSingleton.getInstance();

        // 通过反射修改静态变量isInit的值，然后用反射创建实例
        Field isInitField = SolutionSingleton.class.getDeclaredField("isInit");
        isInitField.setAccessible(true);
        isInitField.set(null, false); // 修改isInit的值
        Constructor constructor = SolutionSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SolutionSingleton reflectionSolutionSingleton = (SolutionSingleton) constructor.newInstance();

        // 这里会输出： false，两个单例不一样，单例模式被破坏了
        System.out.println(reflectionSolutionSingleton == commonSolutionSingleton);
    }
}
