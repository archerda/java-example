package com.github.archerda.designpattern.singleton.destory.serialization;

import java.io.*;

/**
 * 序列化破坏单例模式；
 *
 * Create by archerda on 2017/11/12.
 */
public class BreakingSingleton {

    public static void main(String[] args) throws Exception {

        // 常规方法获取单例对象
        Singleton commonSingleton = Singleton.getInstance();

        // 序列化和反序列化获取单例对象
        File file = File.createTempFile("SerializationBreakingSingleton", ".tmp");
        System.out.println(file.getAbsolutePath());
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(commonSingleton);
        oos.close();
        fos.close();
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Singleton serializationSingleton = (Singleton) ois.readObject();
        ois.close();
        fis.close();
        file.deleteOnExit();

        System.out.println(commonSingleton);
        System.out.println(serializationSingleton);
        // 这里会输出：false，两个实例不一样，单例被破坏了
        System.out.println(commonSingleton == serializationSingleton);
    }
}
