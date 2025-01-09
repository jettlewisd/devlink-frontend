import { createStore } from 'vuex';
import axios from 'axios';

const store = createStore({

    state: {
        projects: [] // Holds the list of projects
    },

    mutations: {
        setProjects(state, projects) {
            state.projects = projects; // Updates the state with fetched projects 
        }
    },

    actions: {
        fetchProjects({ commit }) {
            axios.get('/projects').then(respons)
        }
    }
})