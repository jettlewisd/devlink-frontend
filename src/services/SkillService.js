import api from "@/api";

const SkillService = {

    fetchAllSkills() {
        return api.get('/skills'); 
    },

    fetchSkillById(id) {
        return api.get(`/skills/${id}`); // NOTE: use backticks in the param when performing interpolation 
    },

    fetchSkillsByUserId(userId) {
        return api.get(`/skills/${userId}`); // NOTE: use backticks in the param when performing interpolation 
    },

    createSkill(skill) {
        return api.post('/skills', skill);
    },

    updateSkill(id, skill) {
        return api.put(`/skills/${id}`, skill);
    },

    deleteSkill(id) {
        return api.delete(`/skills/${id}`);
    },

    fetchSkillsByProficiency(proficiencyLevel) {
        return api.get(`/filter/proficiency/${proficiencyLevel}`); // Corresponds to GET /filter/proficiency/{proficiency_level}
    },

    userHasSkill(userId, skillName) {
        return api.get(`/users/${userId}/skills/${skillName}`); // Corresponds to GET /users/{user_id}/skills/{skill_name}
    },
};

export default SkillService;