package com.github.archerda.dubbo.extension.listener;

import com.alibaba.dubbo.rpc.Exporter;
import com.alibaba.dubbo.rpc.ExporterListener;
import com.alibaba.dubbo.rpc.RpcException;

/**
 * 暴露监听扩展;
 *
 * 当有服务暴露时，触发该事件, 只在初始化的时候触发, 只触发一次;
 *
 * 只支持生产者;
 *
 * @author archerda
 * @date 2018/9/11
 */
public class DiyExporterListener implements ExporterListener {

    @Override
    public void exported(Exporter<?> exporter) throws RpcException {
        System.out.println("DiyExporterListener#exported");
        System.out.println(exporter.getInvoker());
    }

    @Override
    public void unexported(Exporter<?> exporter) {
        System.out.println("DiyExporterListener#unexported");
        System.out.println(exporter.getInvoker());
    }
}
