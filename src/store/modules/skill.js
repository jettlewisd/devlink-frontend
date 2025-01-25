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

const mutations = {
    setSkills(state, skills) {
        state.skills = skills;
    },
    setSelectedSkill(state, selectedSkill) {
        state.selectedSkill = selectedSkill;
    },
    setLoading(state, loading) {
        state.loading = loading;
    },
};

const actions = {

    async fetchSkills({commit}) {
        try {
            commit('setLoading', true);
            const response = await SKillService.fetchAllSkills();
            console.log('API response:', response.data);
            commit('setSkills', response.data);
        } catch (error) {
            console.log('Error fetching skills:', error);
            throw error;
        } finally {
            commit('setLoading', false);
        }
    },

    async fetchSkillsById({commit}) {
        try {
            commit('setLoading', true);
            const response = await SKillService.fetchSkillsById(id);
            console.log('API response:', response.data);
            commit('setSelectedProject', response.data);
        } catch (error) {
            console.log('Error fetching skill by ID', error);
            throw error;
        } finally {
            commit('setLoading', false);
        }
    },

    async 
};