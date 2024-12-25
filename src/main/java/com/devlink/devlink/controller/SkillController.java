package com.devlink.devlink.controller;

import com.devlink.devlink.dao.SkillDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skills")
public class SkillController {

    private final SkillDao skillDao;

    @Autowired
    public SkillController(SkillDao skillDao) {
        this.skillDao = skillDao;
    }
}
