package com.github.archerda.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 缓存持有类;
 *
 * @author archerda
 * @date 2018/8/22
 */
public class CacheHolder {
    public static final Map<String, Object> CACHE = new ConcurrentHashMap<>();
}
