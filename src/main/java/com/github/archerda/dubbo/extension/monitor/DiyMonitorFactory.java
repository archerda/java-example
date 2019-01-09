package com.github.archerda.dubbo.extension.monitor;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.monitor.Monitor;
import com.alibaba.dubbo.monitor.MonitorFactory;

/**
 * 监控中心扩展
 *
 * @author archerda
 * @date 2018/9/11
 */
public class DiyMonitorFactory implements MonitorFactory {

    @Override
    public Monitor getMonitor(URL url) {
        return null;
    }
}
