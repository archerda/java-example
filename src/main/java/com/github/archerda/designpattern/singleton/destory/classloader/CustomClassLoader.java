package com.github.archerda.designpattern.singleton.destory.classloader;

import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * Create by archerda on 2017/11/12.
 */
public class CustomClassLoader extends ClassLoader {

    public Object createNewSingleton() throws Exception {
        InputStream is = getClass().getResourceAsStream
                ("/com/github/archerda/designpattern/singleton/destory/classloader/Singleton" +
                ".class");
        byte[] data = new byte[is.available()];
        is.read(data);
        Class<?> clz = defineClass(null, data, 0, data.length);
        Method getInstance = clz.getDeclaredMethod("getInstance");
        // 这里不能cast为Singleton，因为每个类的identity在不同的ClassLoader之间是不同的，所以不可以相互转换
        return getInstance.invoke(null);
    }

    public static void main(String[] args) throws Exception {
        Object commonSingleton = Singleton.getInstance();
        Object customSingleton = new CustomClassLoader().createNewSingleton();

        System.out.println(commonSingleton);
        System.out.println(customSingleton);
        System.out.println(commonSingleton == customSingleton);
    }
}
