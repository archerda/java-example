package com.github.archerda.designpattern.command;

/**
 * 请求接收者：灯
 *
 * Create by archerda on 2017/11/13.
 */
public class LightReceiver {

    private String name;

    public LightReceiver(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Light{" +
                "name='" + name + '\'' +
                '}';
    }

    public void on() {
        System.out.println(name + " light is on");
    }

    public void off() {
        System.out.println(name + " light is off");
    }

}
