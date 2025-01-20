import api from '@/api'; //import axios instance from api.js 

const state = {
    users: [], 
    loading: false, // Add a loading state
};

const getters = {
    allUsers: (state) => state.users, // gettter to get all users
};

const actions = {
    async fetchUsers( {commit } ) {
        try {
            const response = await api.get('/users');  // API call to fetch users
            commit('setUsers', response.data);  // commit the data to the store 
        } catch (error) {
            console.error("Error fetching users:", error);  // handle any errors during the request
        }
    },
};

const mutations = {
    setUsers(state, users) {
        state.users = users;  // Set the users in the state 
    },
};

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
};

