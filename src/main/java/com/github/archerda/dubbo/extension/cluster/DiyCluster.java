package com.github.archerda.dubbo.extension.cluster;

import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.cluster.Cluster;
import com.alibaba.dubbo.rpc.cluster.Directory;

/**
 * 集群扩展
 *
 * 当有多个服务提供方时，将多个服务提供方组织成一个集群，并伪装成一个提供方
 *
 * 仅支持消费者
 *
 * @author archerda
 * @date 2018/9/11
 */
public class DiyCluster implements Cluster {

    @Override
    public <T> Invoker<T> join(Directory<T> directory) throws RpcException {
        System.out.println("DiyCluster#join");
        return new DiyClusterInvoker<>(directory);
    }
}
