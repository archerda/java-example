package com.github.archerda.jdk.spi;

/**
 * @author archerda
 */
public class MongoRepository implements IRepository {

    @Override
    public void save(String data) {
        System.out.println("Save " + data + " to Mongo");
    }
}
