package com.github.archerda.fescar.quickstart.service;

import org.springframework.core.annotation.Order;

/**
 * @author archerda
 */
public interface OrderService {

    /**
     * create order
     */
    Order create(String userId, String commodityCode, int orderCount);
}
