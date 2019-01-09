package com.github.archerda.spring.transaction.aop;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户Service接口实现；
 *
 * @author archerda
 * @date 2018/7/17
 */
@Service("userServiceAop")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;

    @Override
    public boolean updateNameAndAgeWithTransaction(long id, String name, int age) {

        boolean updateNameRet = userDAO.updateNameById(id, name);

        if (!updateNameRet) {
            System.out.println("更新name失败");
            return false;
        }

        boolean updateAgeRet = userDAO.updateAgeById(id, age);

        if (!updateAgeRet) {
            System.out.println("更新age失败");
            return false;
        }

        return true;
    }

    @Override
    public boolean updateNameAndAgeThrowExceptionWithTransaction(long id, String name, int age) {

        boolean updateAgeRet = userDAO.updateAgeById(id, age);

        if (!updateAgeRet) {
            System.out.println("更新age失败");
            return false;
        }

        boolean updateNameRet = userDAO.updateNameById(id, name);

        if (!updateNameRet) {
            System.out.println("更新name失败");
            return false;
        }

        throw new RuntimeException("手动抛出异常");

    }
}
