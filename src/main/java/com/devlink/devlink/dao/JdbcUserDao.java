package com.devlink.devlink.dao;

import com.devlink.devlink.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcUserDao implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public Long createUser(User user) {
        return null;
    }

    @Override
    public boolean updateUser(Long id, User user) {
        return false;
    }

    @Override
    public boolean deleteUser(Long id) {
        return false;
    }

    @Override
    public List<User> findUsersBySkill(String skillName) {
        return null;
    }

    @Override
    public List<User> getUserConnections(Long userId) {
        return null;
    }

    @Override
    public List<User> recommendConnections(Long userId) {
        return null;
    }
}
