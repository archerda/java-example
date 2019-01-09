package com.github.archerda.dubbo.extension.route;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.cluster.Router;
import com.alibaba.dubbo.rpc.cluster.RouterFactory;

/**
 * 路由扩展
 *
 * 从多个服务提者方中选择一个进行调用
 *
 * 注意: SPI机制从URL的protocol属性中获取RouteFactory;
 * 也就是从 /dubbo/com.github.archerda.dubbo.provider.HelloService/routers 读取URL, 然后根据这个URL的protocol来获取SPI的RouteFactory;
 *
 * @author archerda
 * @date 2018/9/11
 */
public class DiyRouteFactory implements RouterFactory {

    @Override
    public Router getRouter(URL url) {
        return new DiyRoute();
    }
}
