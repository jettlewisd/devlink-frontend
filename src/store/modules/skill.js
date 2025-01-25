import SKillService from '@/services/SkillService'


const state = {
    skills: [],
    selectedSkill: null,
    selectedSkills: null,
    loading: false,
}

const getters = {
    allSKills: (state) => state.skills, // get all skills 
    getSelectedSkill: (state) => state.selectedSkill, // get selected skill 
    getSelectedSkills: (state) => state.selectedSkills // get selected skill(s)
};

const mutations = {
    setSkills(state, skills) {
        state.skills = skills;
    },
    setSelectedSkill(state, selectedSkill) {
        state.selectedSkill = selectedSkill;
    },
    setSelectedSkills(state, selectedSkills) {
        state.selectedSkills = selectedSkills;
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

    async fetchSkillById({commit}, id) {
        try {
            commit('setLoading', true);
            const response = await SKillService.fetchSkillById(id);
            console.log('API response:', response.data);
            commit('setSelectedSkill', response.data);
        } catch (error) {
            console.log('Error fetching skill by ID', error);
            throw error;
        } finally {
            commit('setLoading', false);
        }
    },

    async fetchSkillsByUserId({commit}, userId) {
        try {
            commit('setLoading', true);
            const response = await SKillService.fetchSkillsByUserId(userId);
            console.log('API response:', response.data);
            commit('setSelectedSkills', response.data);
        } catch (error) {
            console.log('Error fetching skills by User ID', error);
            throw error;
        } finally {
            commit('setLoading', false);
        }
    },

    async createSkill({dispatch}, skill) {
        try {
            console.log('Creating skill with data:', skill);
            await SKillService.createSkill(skill);
            await dispatch('fetchSkills');
        } catch (error) {
            console.log('Error creating skill:', error);
            throw error;
        }
    },

    async updateSkill({dispatch}, {id, skill}) {
        try {
            await SKillService.updateSkill(id, skill);
            await dispatch('fetchSkills');
        } catch (error) {
            console.log('Error updating skill:', error);
            throw error;
        }
    },

    async deleteSkill({dispatch}, id) {
        try {
            await SKillService.deleteSkill(id);
            await dispatch('fetchSkills');
        } catch (error) {
            console.log('Error deleting skill:', error);
            throw error;
        }
    },

    async fetc

    
};