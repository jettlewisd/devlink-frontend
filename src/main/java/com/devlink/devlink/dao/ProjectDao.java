package com.devlink.devlink.dao;

import com.devlink.devlink.model.Project;

import java.util.List;

public interface ProjectDao {

    // CRUD OPS
    Project getProjectById(Long id);
    List<Project> getAllProjects();
    Long createProject(Project project);
    boolean updateProject(Long id, Project project);
    boolean deleteProject(Long id);

    // Beyond CRUD Methods
    List<Project> getProjectsByCreator(Long createdBy); // Retrieve projects created by a specific user
}
