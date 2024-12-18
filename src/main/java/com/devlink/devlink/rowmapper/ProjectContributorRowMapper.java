package com.devlink.devlink.rowmapper;

import com.devlink.devlink.model.ProjectContributor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Maps rows from the `project_contributors` table to the ProjectContributor model.
 */
public class ProjectContributorRowMapper implements RowMapper<ProjectContributor> {

    @Override
    public ProjectContributor mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProjectContributor projectContributor = new ProjectContributor();

        projectContributor.setUserId(rs.getLong("user_id"));
        projectContributor.setProjectId(rs.getLong("project_id"));
        projectContributor.setRole(rs.getString("role"));
        projectContributor.setDateJoined(rs.getString("date_joined"));

        return projectContributor;
    }
}

