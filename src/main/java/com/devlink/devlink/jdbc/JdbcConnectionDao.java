package com.devlink.devlink.jdbc;

import com.devlink.devlink.dao.ConnectionDao;
import com.devlink.devlink.model.Connection;
import com.devlink.devlink.rowmapper.ConnectionRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcConnectionDao implements ConnectionDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcConnectionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Connection getConnection(Long userId, Long connectedUserId) {
        String sql = "SELECT * FROM connections WHERE user_id = ? AND connected_user_id = ?";
        return jdbcTemplate.queryForObject(sql, new ConnectionRowMapper(), userId, connectedUserId);
    }

    @Override
    public List<Connection> getAllConnections() {
        String sql = "SELECT * FROM connections";
        return jdbcTemplate.query(sql, new ConnectionRowMapper());
    }

    @Override
    public boolean createConnection(Connection connection) {
        String sql = "INSERT INTO connections (user_id, connected_user_id, connection_date) VALUES (?, ?, ?)";
        int rowsInserted = jdbcTemplate.update(
                sql,
                connection.getUserId(),
                connection.getConnectedUserId(),
                connection.getConnectionDate()
        );
        return rowsInserted > 0;
    }

    @Override
    public boolean removeConnection(Long userId, Long connectedUserId) {
        String sql = "DELETE FROM connections WHERE user_id = ? AND connected_user_id = ?";
        int rowsRemoved = jdbcTemplate.update(sql, userId, connectedUserId);
        return rowsRemoved > 0;
    }

    @Override
    public List<Connection> getConnectionsByUserId(Long userId) {
        String sql = "SELECT * FROM connections WHERE user_id = ?";
        return jdbcTemplate.query(sql, new ConnectionRowMapper(), userId);
    }
}
