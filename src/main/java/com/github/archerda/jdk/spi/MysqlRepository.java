package com.github.archerda.jdk.spi;

/**
 * @author archerda
 */
public class MysqlRepository implements IRepository {

    @Override
    public void save(String data) {
        System.out.println("Save " + data + " to Mysql");
    }
}
