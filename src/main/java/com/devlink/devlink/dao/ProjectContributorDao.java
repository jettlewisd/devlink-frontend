package com.devlink.devlink.dao;

import com.devlink.devlink.model.ProjectContributor;

import java.util.List;

public interface ProjectContributorDao {

    // CRUD OPS
    boolean addContributor(ProjectContributor projectContributor);
    ProjectContributor getContributorById(Long userId, Long projectId);
    boolean updateContributor(ProjectContributor projectContributor);
    boolean removeContributor(Long userId, Long projectId);


    // Additional Methods
    List<ProjectContributor> getContributorsByProjectId(Long projectId);
    boolean isUserContributing(Long userId, Long projectId);
}
