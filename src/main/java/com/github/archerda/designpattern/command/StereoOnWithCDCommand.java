package com.github.archerda.designpattern.command;

/**
 * 具体命令：打开音响并播放CD
 *
 * Create by archerda on 2017/11/13.
 */
public class StereoOnWithCDCommand implements Command {
    private StereoReceiver stereoReceiver;

    public StereoOnWithCDCommand(StereoReceiver stereoReceiver) {
        this.stereoReceiver = stereoReceiver;
    }

    @Override
    public void execute() {
        stereoReceiver.on();
        stereoReceiver.setCd();
        stereoReceiver.setVolume(11);
    }
}
