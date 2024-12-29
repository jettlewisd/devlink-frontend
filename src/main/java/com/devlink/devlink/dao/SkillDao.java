package com.devlink.devlink.dao;

import com.devlink.devlink.model.Skill;

import java.util.List;

    public interface SkillDao {

        // CRUD OPS
        Skill getSkillById(Long id);
        List<Skill> getSkillsByUserId(Long userId);
        List<Skill> getAllSkills();
        Long createSkill(Skill skill);
        boolean updateSkill(Long id, Skill skill);
        boolean deleteSkill(Long id);


        // Additional Operations
        List<Skill> findSkillsByProficiency(String proficiencyLevel);
        boolean userHasSkill(Long userId, String skillName);
    }
