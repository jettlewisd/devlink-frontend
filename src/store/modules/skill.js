import SKillService from '@/services/SkillService'

const state = {
    skills: [],
    selectedSkill: null,
    loading: false,
}

const getters = {
    allSKills: (state) => state.skills, // get all skills 
    getSelectedSkill: (state) => state.selectedSkill, // get selected skill 
};

const actions = {

    async fetchSkills({commit}) {
        try {
            commit('setLoading', true);
        }
    }
}