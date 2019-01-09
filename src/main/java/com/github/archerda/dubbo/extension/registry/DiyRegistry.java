package com.github.archerda.dubbo.extension.registry;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.registry.support.AbstractRegistry;

/**
 * @author archerda
 * @date 2018/9/11
 */
public class DiyRegistry extends AbstractRegistry {

    public DiyRegistry(URL url) {
        super(url);
    }

    @Override
    public boolean isAvailable() {
        return false;
    }
}
