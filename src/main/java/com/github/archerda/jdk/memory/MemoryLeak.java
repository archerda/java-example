package com.github.archerda.jdk.memory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 内存泄露示例
 *
 * @author archerda
 * @date 2018/8/7
 */
public class MemoryLeak {

    public static void main(String[] args) throws IOException {
        List<Object> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Object o = new Object();
            list.add(o);
            o = null;
        }

        //... 往下, list再也不使用了
    }
}
