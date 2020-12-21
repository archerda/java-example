package com.github.archerda.jdk.classes;

/**
 * @author luohuida
 */
public class ClassTest {

    public static class Inner {

    }

    public static void main(String[] args) throws ClassNotFoundException {
        Inner test = new Inner();

        //获取Class对象的3种方式；
        System.out.println(ClassTest.class);
        System.out.println(test.getClass());
        System.out.println(Class.forName("com.github.archerda.jdk.classes.ClassTest"));

        //获取Class名称
        System.out.println("----");
        System.out.println(Inner.class.getName()); //com.archerda.test.ClassTest$Inner
        System.out.println(Inner.class.getSimpleName()); //Inner
        System.out.println(Inner.class.getCanonicalName()); //com.archerda.test.ClassTest.Inner
    }
}
