package com.github.archerda.spring.transaction.programming;

import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * 用户Service接口实现；
 *
 * @author archerda
 * @date 2018/7/17
 */
@Service("userServicePrograming")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;
    @Resource
    private TransactionTemplate transactionTemplate;

    @Override
    public boolean updateNameAndAgeWithTransaction(long id, String name, int age) {

        boolean ret = transactionTemplate.execute(status -> {
            boolean updateNameRet = userDAO.updateNameById(id, name);

            if (!updateNameRet) {
                System.out.println("更新name失败");
                return false;
            }

            boolean updateAgeRet = userDAO.updateAgeById(id, age);

            if (!updateAgeRet) {
                System.out.println("更新age失败");
                status.setRollbackOnly();
                return false;
            }

            return true;
        });

        System.out.println(ret);
        return ret;
    }

    @Override
    public boolean updateNameAndAgeThrowExceptionWithTransaction(long id, String name, int age) {

        boolean ret = transactionTemplate.execute(status -> {

            boolean updateAgeRet = userDAO.updateAgeById(id, age);

            if (!updateAgeRet) {
                System.out.println("更新age失败");
                return false;
            }

            boolean updateNameRet = userDAO.updateNameById(id, name);

            if (!updateNameRet) {
                System.out.println("更新name失败");
                status.setRollbackOnly();
                return false;
            }

            throw new RuntimeException("手动抛出异常");
        });

        System.out.println(ret);
        return ret;
    }
}
