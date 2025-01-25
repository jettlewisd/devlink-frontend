import api from "@/api";

const SkillService = {

    fetchAllSkills() {
        return api.get('/skills'); 
    },

    fetchSkillById(id) {
        return api.get(`/skills/${id}`); // NOTE: use backticks in the param when performing interpolation 
    },

    fetchSkillsByUserId(id) {
        return api.get(`/skills/${userId}`); // NOTE: use backticks in the param when performing interpolation 
    },
};