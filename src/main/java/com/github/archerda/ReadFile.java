package com.github.archerda;

import com.google.common.collect.Sets;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @author luohuida
 */
public class ReadFile {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Administrator\\Downloads\\key-long-expire-err2.log");
        List<String> lines = FileUtils.readLines(file);
        Set<String> keys = Sets.newHashSet();
        Set<String> pids = Sets.newHashSet();
        for (String line : lines) {
            line = line.substring(line.indexOf("'") + 1, line.lastIndexOf("_"));
            //String[] values = line.split("'");
            //String content = values[1]; // // p_specific_market_items_2208488351
            keys.add(line.substring(0, line.lastIndexOf("_")));
            pids.add(line.substring(line.lastIndexOf("_") + 1));
        }
        System.out.println(keys);
        for (String pid : pids) {
            System.out.println(pid + ",");
        }

    }
}
