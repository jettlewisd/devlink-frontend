package com.devlink.devlink.jdbc;

import com.devlink.devlink.dao.PostDao;
import com.devlink.devlink.model.Post;
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
        return null;
    }

    @Override
    public Post getPostById(Long id) {
        return null;
    }

    @Override
    public boolean updatePost(Long id, Post post) {
        return false;
    }

    @Override
    public boolean deletePost(Long id) {
        return false;
    }

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        return null;
    }

    @Override
    public List<Post> getAllPosts() {
        return null;
    }
}
