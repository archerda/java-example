package com.github.archerda.dubbo.extension.route;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.cluster.Router;

import java.util.List;

/**
 * 路由扩展;
 *
 * @author archerda
 * @date 2018/9/11
 */
public class DiyRoute implements Router {

    @Override
    public URL getUrl() {
        return null;
    }

    @Override
    public <T> List<Invoker<T>> route(List<Invoker<T>> invokers, URL url, Invocation invocation) throws RpcException {
        return invokers;
    }

    @Override
    public int compareTo(Router o) {
        return 0;
    }
}
