package com.devlink.devlink.controller;


import com.devlink.devlink.dao.UserDao;
import com.devlink.devlink.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userDao.getUserById(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @PostMapping
    public Long createUser(@RequestBody User user){
        return userDao.createUser(user);
    }

    @PutMapping("/{id}")
    public boolean updateUser(@PathVariable Long id, @RequestBody User user) {
        return userDao.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        return userDao.deleteUser(id);
    }

    @GetMapping("/skills/{skillname}")
    public List<User> findUsersBySkill(@PathVariable String skillName){
        return userDao.findUsersBySkill(skillName);
    }

    @GetMapping("/{id}/connections")
    public List<User> getUserConnections(@PathVariable Long id) {
        return userDao.getUserConnections(id);
    }

    @GetMapping("/{userId}/recommendations")
    public List<User> recommendConnections(@PathVariable Long userId) {
        return userDao.recommendConnections(userId);
    }
}
