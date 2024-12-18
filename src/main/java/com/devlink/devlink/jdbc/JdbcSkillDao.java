package com.devlink.devlink.jdbc;

import com.devlink.devlink.dao.SkillDao;
import com.devlink.devlink.model.Skill;
import com.devlink.devlink.rowmapper.SkillRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcSkillDao implements SkillDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcSkillDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Skill getSkillById(Long id) {
        String sql = "SELECT * FROM skills WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new SkillRowMapper(), id);
    }

    @Override
    public List<Skill> getSkillsByUserId(Long userId) {
        String sql = "SELECT * FROM skills WHERE user_id = ?";
        return jdbcTemplate.query(sql, new SkillRowMapper(), userId);
    }

    @Override
    public List<Skill> getAllSkills() {
        String sql = "SELECT * FROM skills";
        return jdbcTemplate.query(sql, new SkillRowMapper());
    }

    @Override
    public Long createSkill(Skill skill) {
        String sql = "INSERT INTO skills (user_id, skill_name, proficiency_level) " + "VALUES (?, ?, ?) RETURNING id";
        return jdbcTemplate.queryForObject(
                sql,
                Long.class,
                skill.getUserId(),
                skill.getSkillName(),
                skill.getProficiencyLevel()
        );
    }

    @Override
    public boolean updateSkill(Long id, Skill skill) {
        String sql = "UPDATE skills SET skill_name = ?, proficiency_level = ? WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(
                sql,
                skill.getSkillName(),
                skill.getProficiencyLevel(),
                id
        );
        return rowsAffected > 0;
    }

    @Override
    public boolean deleteSkill(Long id) {
        String sql = "DELETE FROM skills WHERE id =?";
        int rowsAffected = jdbcTemplate.update(sql, id);
        return rowsAffected > 0;
    }

    @Override
    public List<Skill> findSkillsByProficiency(String proficiencyLevel) {
        String sql = "SELECT * FROM skills WHERE proficiency_level = ?";
        return jdbcTemplate.query(sql, new SkillRowMapper(), proficiencyLevel);
    }

    @Override
    public boolean userHasSkill(Long userId, String skillName) {
        String sql = "SELECT COUNT(*) FROM skills WHERE user_id = ? AND skill_name = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, userId, skillName);
        return count != null && count > 0;
    }
}
