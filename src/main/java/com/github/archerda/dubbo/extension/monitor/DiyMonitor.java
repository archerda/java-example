package com.github.archerda.dubbo.extension.monitor;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.monitor.Monitor;

import java.util.List;

/**
 * desc
 *
 * @author archerda
 * @date 2018/9/11
 */
public class DiyMonitor implements Monitor {


    @Override
    public URL getUrl() {
        return null;
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public void destroy() {

    }

    @Override
    public void collect(URL statistics) {

    }

    @Override
    public List<URL> lookup(URL query) {
        return null;
    }
}
