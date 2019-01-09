package com.github.archerda.designpattern.command;

/**
 * 具体命令：关音响
 *
 * Create by archerda on 2017/11/13.
 */
public class StereoOffCommand implements Command {
    private StereoReceiver stereoReceiver;

    public StereoOffCommand(StereoReceiver stereoReceiver) {
        this.stereoReceiver = stereoReceiver;
    }

    @Override
    public void execute() {
        stereoReceiver.off();
    }
}
