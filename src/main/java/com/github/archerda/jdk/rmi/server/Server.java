package com.github.archerda.jdk.rmi.server;

import com.github.archerda.jdk.rmi.HelloService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * RMI提供者；
 *
 * @author archerda
 * @date 2018/7/25
 */
public class Server {

    public static void main(String[] args) {

        try {

            /*
            生成$Proxy0的class文件
             */
            System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

            HelloService helloService = new HelloServiceImpl();

            // stub 是一个代理类，Proxy[HelloService,RemoteObjectInvocationHandler[UnicastRef [liveRef: [endpoint:[10.21.0.47:62859](local),objID:[31ab4d6a:164cfd5adf4:-7fff, 6602863228525022160]]]]]
            HelloService stub = (HelloService) UnicastRemoteObject.exportObject(helloService, 0);

            Registry registry = LocateRegistry.getRegistry();

            // 如果这里报了 ClassNotFoundException:HelloService，
            // 是因为执行 rmiregistry 的时候没有带上 classpath，
            // 需要先 export CLASSPATH = "/Users/Archerda/Desktop/java-example/target/classes"；
            registry.bind("HelloService", stub);

            System.out.println("Server already!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
