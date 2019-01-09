package com.github.archerda.jdk.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 定义远程接口；
 * 必须继承 java.rmi.Remote 接口；
 *
 * @author archerda
 * @date 2018/7/25
 */
public interface HelloService extends Remote {

    String sayHello(String name) throws RemoteException;

}
