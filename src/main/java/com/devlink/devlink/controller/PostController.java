package com.devlink.devlink.controller;


import com.devlink.devlink.dao.PostDao;
import com.devlink.devlink.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Post> getAllPosts




}
