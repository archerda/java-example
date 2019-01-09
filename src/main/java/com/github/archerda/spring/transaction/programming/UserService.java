package com.github.archerda.spring.transaction.programming;

/**
 * 用户Service接口；
 *
 * @author archerda
 * @date 2018/7/17
 */
public interface UserService {

    boolean updateNameAndAgeWithTransaction(long id, String name, int age);

    boolean updateNameAndAgeThrowExceptionWithTransaction(long id, String name, int age);
}

