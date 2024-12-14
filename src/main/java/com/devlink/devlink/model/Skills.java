package com.devlink.devlink.model;

public class Skills {

    private Long id;

    private Long userId;

    private String skillName;

    private String proficiencyLevel;

    public Skills() {
    }

    public Skills(Long id, Long userId, String skillName, String proficiencyLevel){
        this.id = id;
        this.userId = userId;
        this.skillName = skillName;
        this.proficiencyLevel = proficiencyLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getProficiencyLevel() {
        return proficiencyLevel;
    }

    public void setProficiencyLevel(String proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }
}
