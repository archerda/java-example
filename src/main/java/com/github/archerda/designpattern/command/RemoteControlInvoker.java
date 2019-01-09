package com.github.archerda.designpattern.command;

import java.util.Arrays;

/**
 * 发起请求者：遥控器
 *
 * Create by archerda on 2017/11/13.
 */
public class RemoteControlInvoker {
    private static final int SLOT_NUM = 7
            ;

    private Command[] onCommands;
    private Command[] offCommands;

    public RemoteControlInvoker() {
        onCommands = new Command[SLOT_NUM];
        offCommands = new Command[SLOT_NUM];

        for (int i = 0; i < SLOT_NUM; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onBtnWasPushed(int slot) {
        onCommands[slot].execute();
    }

    public void offBtnWasPushed(int slot) {
        offCommands[slot].execute();
    }

    @Override
    public String toString() {
        return "RemoteControl{" +
                "onCommands=" + Arrays.toString(onCommands) +
                ", offCommands=" + Arrays.toString(offCommands) +
                '}';
    }
}
