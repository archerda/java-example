package com.github.archerda.dubbo.extension.loadbalance;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.cluster.loadbalance.AbstractLoadBalance;

import java.util.List;

/**
 * 负载均衡扩展;
 *
 * @author archerda
 * @date 2018/9/11
 */
public class DiyLoadBalance extends AbstractLoadBalance {

    @Override
    protected <T> Invoker<T> doSelect(List<Invoker<T>> invokers, URL url, Invocation invocation) {
        System.out.println("DiyLoadBalance#doSelect");
        return invokers.get(0);
    }
}
