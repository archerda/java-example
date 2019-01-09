package com.github.archerda.dubbo.extension.protocol;

import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.protocol.AbstractExporter;

/**
 * 自定义暴露器;
 *
 * @author archerda
 * @date 2018/9/10
 */
public class DiyExporter<T> extends AbstractExporter<T> {

    public DiyExporter(Invoker<T> invoker) {
        super(invoker);
    }
}
