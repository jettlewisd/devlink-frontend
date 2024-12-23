package com.devlink.devlink.controller;

import com.devlink.devlink.dao.ConnectionDao;
import com.devlink.devlink.model.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/connections")
public class ConnectionController {

    private final ConnectionDao connectionDao;

    @Autowired
    public ConnectionController(ConnectionDao connectionDao) {
        this.connectionDao = connectionDao;
    }


    @GetMapping
    public List<Connection> getAllConnections() {
        return connectionDao.getAllConnections();
    }

    @GetMapping("/{userId}/{connectedUserId}")
    public Connection getConnection(@PathVariable Long userId, @PathVariable Long connectedUserId){
        return connectionDao.getConnection(userId, connectedUserId);
    }

    @PostMapping
    public boolean createConnection(@RequestBody Connection connection) {
        return connectionDao.createConnection(connection);
    }

    @DeleteMapping("/{userId}/{connectedUserId}")
    public boolean removeConnection(@PathVariable Long userId, @PathVariable Long connectedUserId) {
        return connectionDao.removeConnection(userId, connectedUserId);
    }

    @GetMapping("/user/{userId}")
    public List<Connection> getConnectionsByUserId(@PathVariable Long userId){
        return connectionDao.getConnectionsByUserId(userId);
    }

}
