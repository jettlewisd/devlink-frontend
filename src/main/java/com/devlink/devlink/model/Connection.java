package com.devlink.devlink.model;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class Connection {

    private Long userId;
    private Long connectedUserId;
    private LocalDate connectionDate;

    public Connection() {
    }

    public Connection(Long userId, Long connectedUserId, LocalDate connectionDate) {
        this.userId = userId;
        this.connectedUserId = connectedUserId;
        this.connectionDate = connectionDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getConnectedUserId() {
        return connectedUserId;
    }

    public void setConnectedUserId(Long connectedUserId) {
        this.connectedUserId = connectedUserId;
    }

    public LocalDate getConnectionDate() {
        return connectionDate;
    }

    public void setConnectionDate(LocalDate connectionDate) {
        this.connectionDate = connectionDate;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "userId=" + userId +
                ", connectedUserId=" + connectedUserId +
                ", connectionDate=" + connectionDate +
                '}';
    }
}
