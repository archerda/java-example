package com.github.archerda.cache.cacheaside;

import com.github.archerda.cache.CacheHolder;
import com.github.archerda.cache.DBHolder;

/**
 * Cache Aside 缓存模式;
 *
 * @author archerda
 * @date 2018/8/22
 */
public class Main {


    private Object read(String key) {

        // 从cache中获取数据;
        Object result = CacheHolder.CACHE.get(key);

        if (result != null) {
            // 命中, 直接返回;
            return result;
        } else {

            // 未命中, 从db中获取数据;
            result = DBHolder.get(key);

            if (result != null) {
                // 更新cache;
                CacheHolder.CACHE.put(key, result);
            }

            return result;
        }
    }

    private boolean write(String key, Object object) {

        // ①更新db;
        boolean ret = DBHolder.update(key, object);

        if (ret) {
            // ②使cache失效;
            CacheHolder.CACHE.remove(key);
        }

        return ret;
    }
}
