package com.github.archerda.jdk.classloader.extension;

/**
 * Create by archerda on 2017/08/06.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Extension Classloader加载的类库有：");
        System.out.println(System.getProperty("java.ext.dirs"));

        // 因为Extension的加载器Bootstrap加载器不是标准的ClassLoader实例，所以Extension的父类会是一个null；
        ClassLoader extensionClassloader = ClassLoader.getSystemClassLoader().getParent();
        System.out.println("the parent of extension classloader : " + extensionClassloader.getParent());
    }
}
