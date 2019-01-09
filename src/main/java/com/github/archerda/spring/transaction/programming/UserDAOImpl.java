package com.github.archerda.spring.transaction.programming;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 用户DAO接口实现类；
 *
 * @author archerda
 * @date 2018/7/17
 */
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

    @Resource
    private DataSource dataSource;

    @Override
    public UserEntity addUser(UserEntity userEntity) {
        String sql = "INSERT INTO `user`(`name`, `age`) VALUES(?, ?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, userEntity.getName(), userEntity.getAge());
        return userEntity;
    }

    @Override
    public UserEntity getById(long id) {
        String sql = "SELECT * FROM `user` WHERE `id` = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        UserEntity userEntity = jdbcTemplate.queryForObject(sql, new Object[]{id},
                new BeanPropertyRowMapper<>(UserEntity.class));
        return userEntity;
    }

    @Override
    public boolean updateNameById(long id, String name) {
        String sql = "UPDATE `user` SET `name` = ? WHERE `id` = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int rows = jdbcTemplate.update(sql, name, id);
        return rows > 0;
    }

    @Override
    public boolean updateAgeById(long id, int age) {
        String sql = "UPDATE `user` SET `age` = ? WHERE `id` = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int rows = jdbcTemplate.update(sql, age, id);
        return rows > 0;
    }
}
