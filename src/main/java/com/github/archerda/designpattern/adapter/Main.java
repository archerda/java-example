package com.github.archerda.designpattern.adapter;

/**
 * Client：客户端
 *
 * Create by archerda on 2017/11/20.
 */
public class Main {

    public static void main(String[] args) {
        // 要的是Duck，却只有Turkey，那就写个适配器吧
        Turkey turkey = new WildTurkey();
        Duck adapter = new TurkeyAdapter(turkey);
        adapter.quack();
        adapter.fly();
    }
}
