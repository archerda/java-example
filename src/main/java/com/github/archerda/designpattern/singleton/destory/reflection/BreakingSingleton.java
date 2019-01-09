package com.github.archerda.designpattern.singleton.destory.reflection;

import com.github.archerda.designpattern.singleton.sync.Singleton;

import java.lang.reflect.Constructor;


/**
 * 反射破坏单例模式
 *
 * Create by archerda on 2017/11/12.
 */
public class BreakingSingleton {

    public static void main(String[] args) throws Exception {

        // 常规方法获取实例
        Singleton commonSingleton = Singleton.getInstance();

        // 通过反射获取实例
        Constructor constructor = Singleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton reflectionSingleton = (Singleton) constructor.newInstance();

        // 这里会输出： false
        System.out.println(reflectionSingleton == commonSingleton);
    }
}
