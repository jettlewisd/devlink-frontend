package com.devlink.devlink.jdbc;

import com.devlink.devlink.dao.UserDao;
import com.devlink.devlink.model.User;
import com.devlink.devlink.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcUserDao implements UserDao {

    private final JdbcTemplate jdbcTemplate;

  @Autowired
    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User getUserById(Long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    @Override
    public Long createUser(User user) {
        String sql = "INSERT INTO users (first_name, last_name, email, password) " + "VALUES (?, ?, ?, ?, ?) RETURNING id";
        return jdbcTemplate.queryForObject(
                sql,
                Long.class,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword()
        );
    }

    @Override
    public boolean updateUser(Long id, User user) {
        String sql = "UPDATE users SET first_name = ?, last_name = ?, email = ?, password = ? WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(
                sql,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                id
        );
        return rowsAffected > 0;
    }

    @Override
    public boolean deleteUser(Long id) {
        String sql = "DELETE FROM users WHERE id =?";
        int rowsAffected = jdbcTemplate.update(sql, id);
        return rowsAffected > 0;
    }

    // Find Users by Skill (non-CRUD method)
    @Override
    public List<User> findUsersBySkill(String skillName) {
        String sql = "SELECT u.id, u.first_name, u.last_name, u.email, u.password " +
                "FROM users u " +
                "JOIN skills s ON u.id = s.user_id " +
                "WHERE s.skill_name = ?";
        return jdbcTemplate.query(sql, new UserRowMapper(), skillName);
    }

    // Get User Connections (non-CRUD method)
    @Override
    public List<User> getUserConnections(Long userId) {
        String sql = "SELECT u.id, u.first_name, u.last_name, u.email, u.password " +
                "FROM users u " +
                "JOIN connections c ON u.id = c.connected_user_id " +
                "WHERE c.user_id = ?";
        return jdbcTemplate.query(sql, new UserRowMapper(), userId);
    }

    // Recommend Connections (non-CRUD method)
    @Override
    public List<User> recommendConnections(Long userId) {
        String sql = "SELECT DISTINCT u.id, u.first_name, u.last_name, u.email, u.password " +
                "FROM users u " +
                "JOIN connections c1 ON u.id = c1.connected_user_id " +
                "JOIN connections c2 ON c1.user_id = c2.connected_user_id " +
                "WHERE c2.user_id = ? AND u.id != ?";
        return jdbcTemplate.query(sql, new UserRowMapper(), userId, userId);
    }
}
