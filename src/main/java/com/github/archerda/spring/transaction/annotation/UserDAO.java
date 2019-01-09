package com.github.archerda.spring.transaction.annotation;

/**
 * 用户DAO接口；
 *
 * @author archerda
 * @date 2018/7/17
 */
public interface UserDAO {

    UserEntity addUser(UserEntity userEntity);

    UserEntity getById(long id);

    boolean updateNameById(long id, String name);

    boolean updateAgeById(long id, int age);
}
