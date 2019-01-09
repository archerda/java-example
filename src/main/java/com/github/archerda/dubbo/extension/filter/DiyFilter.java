package com.github.archerda.dubbo.extension.filter;

import com.alibaba.dubbo.rpc.*;

/**
 * 自定义调用拦截扩展;
 *
 * 每次主动调用和被调用都会触发;
 *
 * 支持消费者和生产者;
 *
 * @author archerda
 * @date 2018/9/10
 */
public class DiyFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("DiyFilter#invoke");
        return invoker.invoke(invocation);
    }
}
