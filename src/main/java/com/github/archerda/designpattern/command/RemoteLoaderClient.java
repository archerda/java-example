package com.github.archerda.designpattern.command;

/**
 * 客户端
 *
 * Create by archerda on 2017/11/13.
 */
public class RemoteLoaderClient {

    public static void main(String[] args) {

        // 创建 Receiver（请求接收者）
        LightReceiver livingRoomLightReceiver = new LightReceiver("Living Room");
        LightReceiver kitchenRoomLightReceiver = new LightReceiver("Kitchen Room");
        StereoReceiver stereoReceiver = new StereoReceiver("Living Room");

        // 创建 Command（通过命令将发起请求者和请求接收者解耦）
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLightReceiver);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLightReceiver);
        LightOnCommand kitchenRoomLightOn = new LightOnCommand(kitchenRoomLightReceiver);
        LightOffCommand kitchenRoomLightOff = new LightOffCommand(kitchenRoomLightReceiver);
        StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereoReceiver);
        StereoOffCommand stereoOff = new StereoOffCommand(stereoReceiver);

        // 创建 Invoker（发起请求者）
        RemoteControlInvoker remoteControlInvoker = new RemoteControlInvoker();
        remoteControlInvoker.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControlInvoker.setCommand(1, kitchenRoomLightOn, kitchenRoomLightOff);
        remoteControlInvoker.setCommand(2, stereoOnWithCD, stereoOff);

        // 打开0号开关，至于接下来谁来响应这个动作，Invoker并不关心
        // ...
        remoteControlInvoker.onBtnWasPushed(0);
        remoteControlInvoker.offBtnWasPushed(0);
        remoteControlInvoker.onBtnWasPushed(1);
        remoteControlInvoker.offBtnWasPushed(1);
        remoteControlInvoker.onBtnWasPushed(2);
        remoteControlInvoker.offBtnWasPushed(2);
    }
}
