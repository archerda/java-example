package com.github.archerda.dubbo.extension.registry;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.registry.Registry;
import com.alibaba.dubbo.registry.RegistryFactory;

/**
 * 注册中心扩展
 *
 * @author archerda
 * @date 2018/9/11
 */
public class DiyRegistryFactory implements RegistryFactory {
    @Override
    public Registry getRegistry(URL url) {
        System.out.println("DiyRegistryFactory#getRegistry");
        return new DiyRegistry(url);
    }
}
