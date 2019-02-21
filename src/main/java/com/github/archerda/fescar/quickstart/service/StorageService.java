package com.github.archerda.fescar.quickstart.service;

/**
 * @author archerda
 */
public interface StorageService {

    /**
     * deduct storage count
     */
    void deduct(String commodityCode, int count);
}
