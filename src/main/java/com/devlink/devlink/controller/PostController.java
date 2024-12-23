package com.devlink.devlink.controller;


import com.devlink.devlink.dao.PostDao;
import com.devlink.devlink.model.Post;
import com.sun.source.tree.BreakTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostDao postDao;

    @Autowired
    public PostController(PostDao postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postDao.getPostById(id);
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postDao.getAllPosts();
    }

    @PostMapping
    public Long createPost(@RequestBody Post post) {
        return postDao.createPost(post);
    }

    @PutMapping("/{id}")
    public boolean updatePost(@PathVariable Long id, @RequestBody Post post) {
        return postDao.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    public boolean deletePost(@PathVariable Long id) {
        return postDao.deletePost(id);
    }

    @GetMapping("/users/{userId}")
    public List<Post> getPostsByUserId(@PathVariable Long userId) {
        return postDao.getPostsByUserId(userId);
    }
}
