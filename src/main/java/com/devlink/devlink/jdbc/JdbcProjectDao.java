package com.devlink.devlink.jdbc;

import com.devlink.devlink.dao.ProjectDao;
import com.devlink.devlink.model.Project;
import com.devlink.devlink.rowmapper.ProjectRowMapper;
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
        String sql = "SELECT * FROM projects WHERE id =?";
        return jdbcTemplate.queryForObject(sql, new ProjectRowMapper(), id);
    }

    @Override
    public List<Project> getAllProjects() {
        String sql = "SELECT * FROM projects";
        return jdbcTemplate.query(sql, new ProjectRowMapper());
    }

    @Override
    public Long createProject(Project project) {
        String sql = "INSERT INTO projects (name, description, start_date, end_date, created_by) " +
                "VALUES (?, ?, ?, ?, ?) RETURNING id";
        return jdbcTemplate.queryForObject(
                sql,
                Long.class,
                project.getName(),
                project.getDescription(),
                project.getStartDate(),
                project.getEndDate(),
                project.getCreatedBy()
        );
    }

    @Override
    public boolean updateProject(Long id, Project project) {
        String sql = "UPDATE projects SET name = ?, description = ?, start_date = ?, end_date = ?, created_by = ? WHERE id = ?";
        int rowsUpdated = jdbcTemplate.update(
                sql,
                project.getName(),
                project.getDescription(),
                project.getStartDate(),
                project.getEndDate(),
                project.getCreatedBy(),
                id
        );
        return rowsUpdated > 0;
    }

    @Override
    public boolean deleteProject(Long id) {
        String sql = "DELETE FROM projects WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, id);
        return rowsAffected > 0;
    }

    @Override
    public List<Project> getProjectsByCreator(Long createdBy) {
        String sql = "SELECT * FROM projects where created_by = ?";
        return jdbcTemplate.query(sql, new ProjectRowMapper(), createdBy);
    }
}
