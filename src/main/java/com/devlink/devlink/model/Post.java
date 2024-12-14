package com.devlink.devlink.model;

import java.time.LocalDate;

public class Post {

    private Long id;
    private Long userId;
    private String content;
    private LocalDate createdAt;

    public Post() {
    }

    public Post(Long id, Long userId, String content, LocalDate createdAt) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
