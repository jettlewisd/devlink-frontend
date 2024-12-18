package com.devlink.devlink.jdbc;

import com.devlink.devlink.dao.ProjectContributorDao;
import com.devlink.devlink.model.ProjectContributor;
import com.devlink.devlink.rowmapper.ProjectContributorRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public boolean addContributor(ProjectContributor projectContributor) {
        String sql = "INSERT INTO project_contributors (user_id, project_id, role, date_joined) VALUES (?, ?, ?, ?)";
        int rowsAffected = jdbcTemplate.update(
                sql,
                projectContributor.getUserId(),
                projectContributor.getProjectId(),
                projectContributor.getRole(),
                projectContributor.getDateJoined()
        );
        return rowsAffected > 0;
    }

    @Override
    public ProjectContributor getContributorById(Long userId, Long projectId) {
        String sql = "SELECT * FROM project_contributors WHERE user_id = ? AND project_id = ?";
        return jdbcTemplate.queryForObject(sql, new ProjectContributorRowMapper(), userId, projectId);
    }

    @Override
    public boolean updateContributor(ProjectContributor projectContributor) {
        String sql = "UPDATE project_contributors SET role = ?, date_joined = ? WHERE user_id = ? AND project_id = ?";
        int rowsAffected = jdbcTemplate.update(
                sql,
                projectContributor.getRole(),
                projectContributor.getDateJoined(),
                projectContributor.getUserId(),
                projectContributor.getProjectId()
        );
        return rowsAffected > 0;
    }

    @Override
    public boolean removeContributor(Long userId, Long projectId) {
        String sql = "DELETE FROM project_contributors WHERE user_id = ? AND project_id = ?";
        int rowsAffected = jdbcTemplate.update(sql, userId, projectId);
        return rowsAffected > 0;
    }

    @Override
    public List<ProjectContributor> getContributorsByProjectId(Long projectId) {
        String sql = "SELECT * FROM project_contributors WHERE project_id = ?";
        return jdbcTemplate.query(sql, new ProjectContributorRowMapper(), projectId);
    }

    @Override
    public List<ProjectContributor> getProjectsByUserId(Long userId) {
        String sql = "SELECT * FROM project_contributors WHERE user_id = ?";
        return jdbcTemplate.query(sql, new ProjectContributorRowMapper(), userId);
    }

    @Override
    public boolean isUserContributing(Long userId, Long projectId) {
        String sql = "SELECT COUNT(*) FROM project_contributors WHERE user_id = ? AND project_id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, userId, projectId);
        return count != null && count > 0;
    }
}
