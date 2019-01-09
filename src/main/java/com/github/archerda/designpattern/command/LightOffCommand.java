package com.github.archerda.designpattern.command;

/**
 * 具体命令： 关灯
 *
 * Create by archerda on 2017/11/13.
 */
public class LightOffCommand implements Command {
    private LightReceiver lightReceiver;

    public LightOffCommand(LightReceiver lightReceiver) {
        this.lightReceiver = lightReceiver;
    }

    @Override
    public void execute() {
        lightReceiver.off();
    }
}
