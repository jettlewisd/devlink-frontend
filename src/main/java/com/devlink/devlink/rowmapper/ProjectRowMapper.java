package com.devlink.devlink.rowmapper;

import com.devlink.devlink.model.Project;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * RowMapper implementation for mapping rows from the "projects" table
 * to Project model objects.
 */
public class ProjectRowMapper implements RowMapper<Project> {

    /**
     * Maps a single row of the "projects" table to a Project object.
     *
     * @param rs     The ResultSet containing the row data.
     * @param rowNum The row number being processed.
     * @return A Project object populated with data from the current row.
     * @throws SQLException If an SQL exception occurs while accessing the ResultSet.
     */
    @Override
    public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
        Project project = new Project();
        project.setId(rs.getLong("id"));
        project.setName(rs.getString("name"));
        project.setDescription(rs.getString("description"));

        // Map LocalDate fields
        project.setStartDate(rs.getDate("start_date").toLocalDate());
        project.setEndDate(rs.getDate("end_date") != null ? rs.getDate("end_date").toLocalDate() : null);

        project.setCreatedBy(rs.getLong("created_by"));

        return project;
    }
}

