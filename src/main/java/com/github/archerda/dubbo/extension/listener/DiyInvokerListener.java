package com.github.archerda.dubbo.extension.listener;

import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.InvokerListener;
import com.alibaba.dubbo.rpc.RpcException;

/**
 * 引用监听扩展;
 * 当有服务引用时，触发该事件, 只在初始化的时候触发, 只触发一次;
 *
 * 只作用于消费者;
 *
 * @author archerda
 * @date 2018/9/11
 */
public class DiyInvokerListener implements InvokerListener {

    @Override
    public void referred(Invoker<?> invoker) throws RpcException {
        System.out.println("referred: " + invoker.getUrl());
    }

    @Override
    public void destroyed(Invoker<?> invoker) {
        System.out.println("destroyed: " + invoker.getUrl());
    }
}
