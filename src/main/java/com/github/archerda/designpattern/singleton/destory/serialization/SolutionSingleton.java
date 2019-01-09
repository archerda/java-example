package com.github.archerda.designpattern.singleton.destory.serialization;

import java.io.*;

/**
 * 通过定义 readResolve方法，防止反序列化破坏单例
 *
 * Create by archerda on 2017/11/12.
 */
public class SolutionSingleton implements Serializable {

    private static final long serialVersionUID = -4799829623335297540L;

    private static SolutionSingleton instance;

    private SolutionSingleton() {}

    public static synchronized SolutionSingleton getInstance() {
        if (instance == null) {
            instance = new SolutionSingleton();
        }
        return instance;
    }

    // 反序列化时，如果定义了readResolve()则直接返回此方法指定的对象。而不需要单独再创建新对象
    private Object readResolve() {
        return instance;
    }

    public static void main(String[] args) throws Exception {

        // 常规方法获取单例对象
        SolutionSingleton commonSingleton = SolutionSingleton.getInstance();

        // 序列化获取单例对象
        File file = File.createTempFile("SerializationBreakingSingleton", "txt");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(commonSingleton);
        oos.close();
        fos.close();

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        SolutionSingleton serializationSingleton = (SolutionSingleton) ois.readObject();
        ois.close();
        fis.close();

        System.out.println(commonSingleton);
        System.out.println(serializationSingleton);

        // 这里会输出：true，单例模式没有被破坏
        System.out.println(commonSingleton == serializationSingleton);
    }

}
