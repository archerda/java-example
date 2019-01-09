package com.github.archerda.jdk.net;

import java.io.IOException;
import java.net.InetAddress;

/**
 * Create by archerda on 2018/03/29.
 */
public class InetAddressTest {

    public static void main(String[] args) throws IOException {

        InetAddress domainNameAddress = InetAddress.getByName("www.baidu.com");
        InetAddress ipAddress = InetAddress.getByName("10.112.32.1");
        InetAddress localAddress = InetAddress.getLocalHost();

    }
}
