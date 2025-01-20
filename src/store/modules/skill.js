import api from '@/api'; //import axios instance from api.js 

const state = {
    skills: [], 
    loading: false, // Add a loading state
};

const getters = {
    allSkills: (state) => state.skills, //getter to get all skills
};

const actions = {
    async fetchSkills( {commit} ) {
        try {
            const response = await api.get('/skills');
            commit('setSkills', response.data);
        } catch (error) {
            console.error("Error fetching skills:", error);
        }
    },
};

const mutations = {
    setSkills(state, skills) {
        state.skills = skills;
    },
};

export default {
    namespaced: true,
    state, 
    getters,
    actions,
    mutations,
};