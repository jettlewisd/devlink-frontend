package com.devlink.devlink.rowmapper;

import com.devlink.devlink.model.Post;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * RowMapper implementation for mapping rows from the "posts" table
 * to Post model objects.
 */
public class PostRowMapper implements RowMapper<Post> {

    /**
     * Maps a single row of the "posts" table to a Post object.
     *
     * @param rs     The ResultSet containing the row data.
     * @param rowNum The row number being processed.
     * @return A Post object populated with data from the current row.
     * @throws SQLException If an SQL exception occurs while accessing the ResultSet.
     */
    @Override
    public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setId(rs.getLong("id"));
        post.setUserId(rs.getLong("user_id"));
        post.setContent(rs.getString("content"));
        post.setCreatedAt(LocalDate.from(rs.getTimestamp("created_at").toLocalDateTime()));
        return post;
    }
}

