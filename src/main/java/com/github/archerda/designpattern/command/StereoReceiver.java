package com.github.archerda.designpattern.command;

/**
 * 请求接收者：音响
 *
 * Create by archerda on 2017/11/13.
 */
public class StereoReceiver {

    private String name;
    private int volume;

    public StereoReceiver(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Stereo{" +
                "name='" + name + '\'' +
                ", volume=" + volume +
                '}';
    }

    public void on() {
        System.out.println(name + " stereo is on");
    }

    public void off() {
        System.out.println(name + " stereo is off");
    }

    public void setCd() {
        System.out.println(name + " is set for CD input");
    }

    public void setDvd() {
        System.out.println(name + " is set for DVD input");
    }

    public void setRadio() {
        System.out.println(name + " is set for Radio input");
    }

}
