package com.github.archerda.jdk.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Create by archerda on 2018/03/29.
 */
public class DatagramSocketTest {

    public static void main(String[] args) throws IOException {

        new DatagramSocketTest().readData();
        new DatagramSocketTest().receiveData();

    }

    private void readData() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();

        byte[] buffer = "0123456789".getBytes();
        InetAddress receiverAddress = InetAddress.getLocalHost();

        // 发送数据；
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, receiverAddress, 80);
        datagramSocket.send(packet);
    }

    private void receiveData() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(80);

        byte[] buffer = new byte[10];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        // 接收数据；
        datagramSocket.receive(packet);

        byte[] receivedData = packet.getData();
    }
}
