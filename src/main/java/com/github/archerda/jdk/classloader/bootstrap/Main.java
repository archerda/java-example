package com.github.archerda.jdk.classloader.bootstrap;

import java.net.URL;

/**
 * Create by archerda on 2017/08/06.
 */
public class Main {
    public static void main(String[] args) {
        // 查看系统的 bootstrap classloader 加载的类库
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        System.out.println("Bootstrap Classloader 加载的类库有：" + urls.length);
        for (URL url : urls) {
            System.out.println(url.getPath());
        }

        // 因为System类是由Bootstrap加载的，所以为null；（不是标准的ClassLoader实例，而是由JVM实现的）
        System.out.println(System.class.getClassLoader());
    }
}
