package com.github.archerda.designpattern.singleton.destory.classloader;

/**
 * 单例：利用同步实现
 *
 * Create by archerda on 2017/11/12.
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
