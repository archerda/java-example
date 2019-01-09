package com.github.archerda.jdk.rmi.client;

import com.github.archerda.jdk.rmi.HelloService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * RMI消费者
 *
 * @author archerda
 * @date 2018/7/25
 */
public class Client {

    public static void main(String[] args) {

        String host = args.length < 1 ? null : args[0];
        try {

            Registry registry = LocateRegistry.getRegistry(host);

            // rmiregistry 保存了 "HelloService" -> HelloService_Stub；
            // helloService是一个代理类（也叫存根类），Proxy[HelloService,RemoteObjectInvocationHandler[UnicastRef [liveRef: [endpoint:[10.21.0.47:62859](remote),objID:[31ab4d6a:164cfd5adf4:-7fff, 6602863228525022160]]]]]
            HelloService helloService = (HelloService) registry.lookup("HelloService");

            String response = helloService.sayHello("archerda");

            System.out.println("Response: " + response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
