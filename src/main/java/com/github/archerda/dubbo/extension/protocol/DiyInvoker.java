package com.github.archerda.dubbo.extension.protocol;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcResult;
import com.alibaba.dubbo.rpc.protocol.AbstractInvoker;

/**
 * desc
 *
 * @author archerda
 * @date 2018/9/10
 */
public class DiyInvoker<T> extends AbstractInvoker<T> {

    public DiyInvoker(Class<T> type, URL url) {
        super(type, url);
    }

    @Override
    protected Result doInvoke(Invocation invocation) {
        return new RpcResult("Diy Invoker Result");
    }
}
