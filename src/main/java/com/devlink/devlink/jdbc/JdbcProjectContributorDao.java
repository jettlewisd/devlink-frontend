package com.devlink.devlink.jdbc;

import com.devlink.devlink.dao.ProjectContributorDao;
import com.devlink.devlink.model.ProjectContributor;
import com.devlink.devlink.rowmapper.ProjectContributorRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcProjectContributorDao implements ProjectContributorDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcProjectContributorDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Long addContributor(ProjectContributor projectContributor) {
        String sql = "INSERT INTO project_contributors ()"
        return null;
    }

    @Override
    public ProjectContributor getContributorById(Long userId, Long projectId) {
        String sql = "SELECT * FROM project_contributors WHERE id =?";
        return jdbcTemplate.queryForObject(sql, new ProjectContributorRowMapper(), projectId);
    }

    @Override
    public boolean updateContributor(ProjectContributor projectContributor) {
        return false;
    }

    @Override
    public boolean removeContributor(Long userId, Long projectId) {
        return false;
    }

    @Override
    public List<ProjectContributor> getContributorsByProjectId(Long projectId) {
        return null;
    }

    @Override
    public List<ProjectContributor> getProjectsByUserId(Long userId) {
        return null;
    }

    @Override
    public boolean isUserContributing(Long userId, Long projectId) {
        return false;
    }
}
