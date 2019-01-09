package com.github.archerda.spring.mvc.javaconfig.dispatcherconfig.respository;

import com.github.archerda.spring.mvc.javaconfig.dispatcherconfig.model.Spittle;

import java.util.List;

/**
 * Create by archerda on 2017/11/24.
 */
public interface SpitterRepository {

    List<Spittle> findSpittles(long max, int count);
}
