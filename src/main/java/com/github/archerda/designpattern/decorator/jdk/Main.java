package com.github.archerda.designpattern.decorator.jdk;

import java.io.*;
import java.net.URL;

/**
 * Create by archerda on 2017/08/24.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        // txt内容是：I'm a TEXT.
        URL resource = Main.class.getClassLoader().getResource("LowerCaseInputStreamTest.txt");
        assert resource != null;
        File file = new File(resource.toURI());

        // 具体组件；
        FileInputStream fileInputStream = new FileInputStream(file);
        // 装饰者；
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        // 自定义装饰者；
        LowerCaseInputStream lowerCaseInputStream = new LowerCaseInputStream(bufferedInputStream);

        int c;
        while ((c = lowerCaseInputStream.read()) > 0) {
            System.out.print((char) c);
        }
        System.out.println("");

    }
}
