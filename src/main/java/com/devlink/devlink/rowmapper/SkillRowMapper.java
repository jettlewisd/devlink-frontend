package com.devlink.devlink.rowmapper;

import com.devlink.devlink.model.Skill;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper implementation for mapping rows from the "skills" table
 * to Skill model objects.
 */
public class SkillRowMapper implements RowMapper<Skill> {

    /**
     * Maps a single row of the "skills" table to a Skill object.
     *
     * @param rs     The ResultSet containing the row data.
     * @param rowNum The row number being processed.
     * @return A Skill object populated with data from the current row.
     * @throws SQLException If an SQL exception occurs while accessing the ResultSet.
     */
    @Override
    public Skill mapRow(ResultSet rs, int rowNum) throws SQLException {
        Skill skill = new Skill();
        skill.setId(rs.getLong("id"));
        skill.setUserId(rs.getLong("user_id"));
        skill.setSkillName(rs.getString("skill_name"));
        skill.setProficiencyLevel(rs.getString("proficiency_level"));
        return skill;
    }
}
