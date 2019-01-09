package com.github.archerda.spring.transaction.annotation.jdkproxy;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户Service接口；
 *
 * @author archerda
 * @date 2018/7/17
 */
public interface UserService {

    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = Exception.class,
            // readOnly = true,
            timeout = 3)
    boolean updateNameAndAgeWithTransaction(long id, String name, int age);

    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = Exception.class,
            // readOnly = true,
            timeout = 3)
    boolean updateNameAndAgeThrowExceptionWithTransaction(long id, String name, int age);
}
