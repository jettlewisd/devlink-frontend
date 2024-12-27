package com.devlink.devlink.controller;

import com.devlink.devlink.dao.SkillDao;
import com.devlink.devlink.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {

    private final SkillDao skillDao;

    @Autowired
    public SkillController(SkillDao skillDao) {
        this.skillDao = skillDao;
    }


    @GetMapping("/{id}")
    public Skill getSkillById(@PathVariable Long id) {
        return skillDao.getSkillById(id);
    }

    @GetMapping("/user_id")
    public List<Skill> getSkillsByUserId(@PathVariable Long userId) {
        return skillDao.getSkillsByUserId(userId);
    }

    @GetMapping
    public List<Skill> getAllSkills() {
        return skillDao.getAllSkills();
    }

    @PostMapping
    public Long createSkill(@RequestBody Skill skill) {
        return skillDao.createSkill(skill);
    }

    @PutMapping("/{id}")
    public boolean updateSkill(@PathVariable Long id, @RequestBody Skill skill) {
        return skillDao.updateSkill(id, skill);
    }

    @DeleteMapping("/{id}")
    public boolean deleteSkill(@PathVariable Long id) {
        return skillDao.deleteSkill(id);
    }
}
