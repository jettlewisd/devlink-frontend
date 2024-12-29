package com.devlink.devlink.dao;

import com.devlink.devlink.model.Post;

import java.util.List;

public interface PostDao {

    // CRUD OPS
    Long createPost(Post post);
    Post getPostById(Long id);
    boolean updatePost(Long id, Post post);
    boolean deletePost(Long id);

    // Beyond CRUD Methods
    List<Post> getPostsByUserId(Long userId);
    List<Post> getAllPosts(); // Retrieve all posts in the system
}
