import api from "@/api";

const state = {
    projectContributors: [],
};

const getters = {
    allProjectContributors: (state) => state.projectContributors,
};

const actions = {
    async fetchProjectContributors({ commit }) {
        try {
            const response = await api.get('/project_contributors');
            commit('setProjectContributors', response.data);
        } catch (erorr) {
            console.error("Error fetching project contributors:" error);
        }
    },
};

const mutations = {
    setProjectContributors(state, projectContributors) {
        state.projectContributors = projectContributors;
    },
};

export default {
    namespaced: true,
    state, 
    getters,
    actions, 
    mutations,
}