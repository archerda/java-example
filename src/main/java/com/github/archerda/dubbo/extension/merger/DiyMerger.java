package com.github.archerda.dubbo.extension.merger;

import com.alibaba.dubbo.rpc.cluster.Merger;

/**
 * 合并结果扩展
 *
 * @author archerda
 * @date 2018/9/11
 */
public class DiyMerger implements Merger<String> {

    @Override
    public String merge(String... items) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String item : items) {
            stringBuilder.append(item).append(";");
        }
        return stringBuilder.toString();
    }
}
