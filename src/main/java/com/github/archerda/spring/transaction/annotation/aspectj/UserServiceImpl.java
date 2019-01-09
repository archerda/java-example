package com.github.archerda.spring.transaction.annotation.aspectj;

import com.github.archerda.spring.transaction.annotation.UserDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用户Service接口实现；
 *
 * @author archerda
 * @date 2018/7/17
 */
@Service("userServiceAnnotationAspectj")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;

    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = Exception.class,
            // readOnly = true,
            timeout = 3)
    @Override
    public boolean updateNameAndAgeWithTransaction(long id, String name, int age) {
        boolean updateNameRet = userDAO.updateNameById(id, name);

        if (!updateNameRet) {
            throw new RuntimeException("更新name失败");
        }

        boolean updateAgeRet = userDAO.updateAgeById(id, age);

        if (!updateAgeRet) {
            throw new RuntimeException("更新age失败");
        }

        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = Exception.class,
            // readOnly = true,
            timeout = 3)
    @Override
    public boolean updateNameAndAgeThrowExceptionWithTransaction(long id, String name, int age) {
        boolean updateAgeRet = userDAO.updateAgeById(id, age);

        if (!updateAgeRet) {
            throw new RuntimeException("更新age失败");
        }

        boolean updateNameRet = userDAO.updateNameById(id, name);

        if (!updateNameRet) {
            throw new RuntimeException("更新name失败");
        }

        throw new RuntimeException("手动抛出异常");
    }
}
