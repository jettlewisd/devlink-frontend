package com.devlink.devlink.rowmapper;

import com.devlink.devlink.model.Connection;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper implementation for mapping rows from the "connections" table
 * to Connection model objects.
 */
public class ConnectionRowMapper implements RowMapper<Connection> {

    /**
     * Maps a single row of the "connections" table to a Connection object.
     *
     * @param rs     The ResultSet containing the row data.
     * @param rowNum The row number being processed.
     * @return A Connection object populated with data from the current row.
     * @throws SQLException If an SQL exception occurs while accessing the ResultSet.
     */
    @Override
    public Connection mapRow(ResultSet rs, int rowNum) throws SQLException {
        Connection connection = new Connection();
        connection.setUserId(rs.getLong("user_id"));
        connection.setConnectedUserId(rs.getLong("connected_user_id"));
        connection.setConnectionDate(rs.getDate("connection_date").toLocalDate());
        return connection;
    }
}
