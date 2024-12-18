package com.devlink.devlink.jdbc;

import com.devlink.devlink.dao.ProjectDao;
import com.devlink.devlink.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcProjectDao implements ProjectDao {

        private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcProjectDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Project getProjectById(Long id) {
        return null;
    }

    @Override
    public List<Project> getAllProjects() {
        return null;
    }

    @Override
    public Long createProject(Project project) {
        return null;
    }

    @Override
    public boolean updateProject(Long id, Project project) {
        return false;
    }

    @Override
    public boolean deleteProject(Long id) {
        return false;
    }

    @Override
    public List<Project> getProjectsByUserId(Long userId) {
        return null;
    }
}
