package com.github.archerda.dubbo.consumer.generic;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.service.GenericService;

import java.io.IOException;

/**
 * @author archerda
 * @date 2018/7/25
 */
public class GenericConsumer {

    public static void main(String[] args) throws IOException {

        ApplicationConfig applicationConfig = new ApplicationConfig("dubbo-provider");

        ReferenceConfig<GenericService> ref = new ReferenceConfig<>();

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("119.29.148.121:2181");

        ref.setTimeout(1000);
        ref.setProtocol("dubbo");
        ref.setConnections(1);
        ref.setInterface("com.github.archerda.dubbo.provider.HelloService");
        ref.setVersion("1.0");
        ref.setApplication(applicationConfig);
        ref.setRegistry(registryConfig);
        ref.setGeneric(true);

        GenericService service = ref.get();
        Object o = service.$invoke("sayHello", new String[] {"java.lang.String"}, new String[]{"Dubbo"});
        System.err.println("Generic result:" + o);
    }
}
