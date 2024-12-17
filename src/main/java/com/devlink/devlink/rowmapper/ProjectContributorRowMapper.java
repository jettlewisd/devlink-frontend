package com.devlink.devlink.rowmapper;

import com.devlink.devlink.model.ProjectContributor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper implementation for mapping rows from the "project_contributors" table
 * to ProjectContributor model objects.
 */
public class ProjectContributorRowMapper implements RowMapper<ProjectContributor> {

    /**
     * Maps a single row of the "project_contributors" table to a ProjectContributor object.
     *
     * @param rs     The ResultSet containing the row data.
     * @param rowNum The row number being processed.
     * @return A ProjectContributor object populated with data from the current row.
     * @throws SQLException If an SQL exception occurs while accessing the ResultSet.
     */
    @Override
    public ProjectContributor mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProjectContributor projectContributor = new ProjectContributor();
        projectContributor.setProjectId(rs.getLong("project_id"));
        projectContributor.setUserId(rs.getLong("user_id"));
        return projectContributor;
    }
}
