package com.devlink.devlink.jdbc;

import com.devlink.devlink.dao.PostDao;
import com.devlink.devlink.model.Post;
import com.devlink.devlink.rowmapper.PostRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcPostDao implements PostDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcPostDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long createPost(Post post) {
        String sql = "INSERT INTO posts (user_id, content, created_at) VALUES (?, ?, ?) RETURNING id";
        return jdbcTemplate.queryForObject(
                sql,
                Long.class,
                post.getUserId(),
                post.getContent(),
                post.getCreatedAt()
        );
    }

    @Override
    public Post getPostById(Long id) {
        String sql = "SELECT * FROM posts WHERE id =?";
        return jdbcTemplate.queryForObject(sql, new PostRowMapper(), id);
    }

    @Override
    public boolean updatePost(Long id, Post post) {
        String sql = "UPDATE posts SET content = ?, created_at = ? WHERE id = ?";
        int rowsUpdated = jdbcTemplate.update(
                sql,
                post.getContent(),
                post.getCreatedAt(),
                id
        );
        return rowsUpdated > 0;
    }

    @Override
    public boolean deletePost(Long id) {
        String sql = "DELETE FROM posts WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, id);
        return rowsAffected > 0;
    }

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        String sql = "SELECT * FROM posts WHERE user_id = ?";
        return jdbcTemplate.query(sql, new PostRowMapper(), userId);
    }

    @Override
    public List<Post> getAllPosts() {
        String sql = "SELECT * FROM posts";
        return jdbcTemplate.query(sql, new PostRowMapper());
    }
}
