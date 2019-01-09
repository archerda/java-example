package com.github.archerda.jdk.lambda.functioninterface;

/**
 * Created by luohd on 16/12/2.
 */
public class Test {

    public static void main(String[] args) {
        print("your name", (String s) -> System.out.println(s + "...."));
    }

    private static void print(String str, FunctionInterfaceTest test) {
        test.print(str);
    }
}
