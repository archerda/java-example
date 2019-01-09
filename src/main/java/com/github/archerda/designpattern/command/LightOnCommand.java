package com.github.archerda.designpattern.command;

/**
 * 具体命令：开灯
 *
 * Create by archerda on 2017/11/13.
 */
public class LightOnCommand implements Command {
    private LightReceiver lightReceiver;

    public LightOnCommand(LightReceiver lightReceiver) {
        this.lightReceiver = lightReceiver;
    }

    @Override
    public void execute() {
        lightReceiver.on();
    }
}
