package com.github.archerda.dubbo.extension.cluster;

import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.cluster.Directory;
import com.alibaba.dubbo.rpc.cluster.LoadBalance;
import com.alibaba.dubbo.rpc.cluster.support.AbstractClusterInvoker;

import java.util.List;

/**
 * @author archerda
 * @date 2018/9/11
 */
public class DiyClusterInvoker<T> extends AbstractClusterInvoker<T> {

    public DiyClusterInvoker(Directory<T> directory) {
        super(directory);
    }

    @Override
    protected Result doInvoke(Invocation invocation,
                              List<Invoker<T>> invokers,
                              LoadBalance loadbalance) throws RpcException {
        System.out.println("DiyClusterInvoker#invoker");
        return invokers.get(0).invoke(invocation);
    }
}
