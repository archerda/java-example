package com.github.archerda.dubbo.extension.protocol;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.protocol.AbstractProtocol;

/**
 * 自定义协议扩展;
 *
 * @author archerda
 * @date 2018/9/10
 */
public class DiyProtocol extends AbstractProtocol {

    @Override
    public int getDefaultPort() {
        return 0;
    }

    @Override
    public <T> DiyExporter<T> export(Invoker<T> invoker) throws RpcException {
        System.out.println("DiyProtocol#exported");
        return new DiyExporter<>(invoker);
    }

    @Override
    public <T> DiyInvoker<T> refer(Class<T> type, URL url) throws RpcException {
        System.out.println("DiyProtocol#refer");
        return new DiyInvoker<>(type, url);
    }
}
