package com.devlink.devlink.model;


public class ProjectContributor {
    private Long userId;
    private Long projectId;
    private String role; // Contributor's role in the project
    private String dateJoined; // Date when the user joined the project

    // Default constructor
    public ProjectContributor() {
    }

    // Parameterized constructor
    public ProjectContributor(Long userId, Long projectId, String role, String dateJoined) {
        this.userId = userId;
        this.projectId = projectId;
        this.role = role;
        this.dateJoined = dateJoined;
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    @Override
    public String toString() {
        return "ProjectContributor{" +
                "userId=" + userId +
                ", projectId=" + projectId +
                ", role='" + role + '\'' +
                ", dateJoined='" + dateJoined + '\'' +
                '}';
    }
}

