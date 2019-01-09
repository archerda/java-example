package com.github.archerda.jdk.classes;

/**
 * Created by luohd on 16/12/2.
 */
public class AnonymousClassTest {

    public static void main(String[] args) {
        new AnonymousClassTest(){
            public void print(String name) {
                System.out.println(name);
            }
        }.print("hello");
    }

    public void print() {
        System.out.println("test");
    }

}
