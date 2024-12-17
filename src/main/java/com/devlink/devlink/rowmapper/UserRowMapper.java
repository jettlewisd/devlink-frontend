package com.devlink.devlink.rowmapper;

import com.devlink.devlink.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper implementation for mapping rows from the "users" table
 * to User model objects.
 */
public class UserRowMapper implements RowMapper<User> {

    /**
     * Maps a single row of the "users" table to a User object.
     *
     * @param rs     The ResultSet containing the row data.
     * @param rowNum The row number being processed.
     * @return A User object populated with data from the current row.
     * @throws SQLException If an SQL exception occurs while accessing the ResultSet.
     */
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        return user;
    }
}
