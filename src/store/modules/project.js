import axios from '@/api'; //import axios instance from api.js 

const state = {
    projects: [],  // this array will store the lists of projects
};

const getters = {
    allProjects: (state) => state.projects,  // getter to retrieve all projects
};

const actions = {
    async fetchProjects({ commit }) {
        try {
            const response = await api.get('/api/projects');  // API call to fetch projects
            commit('setProjects', response.data);  // commit the data to the store 
        } catch (error) {
            console.error("Error fetching projects:", error);  // handle any errors during the request
        }
    },
};

const mutations = {
    setProjects(state, projects) {
        state.projects = projects;  // Set the projects in the state 
    },
};

export default {
    state, 
    getters,
    actions,
    mutations,
};