package com.devlink.devlink.controller;

import com.devlink.devlink.dao.ConnectionDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/connections")
public class ConnectionController {

    private final ConnectionDao connectionDao;

    public ConnectionController(ConnectionDao connectionDao) {
        this.connectionDao = connectionDao;
    }

    
}
