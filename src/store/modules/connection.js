import api from "@/api";

const state = {
    connections: [],
    loading: false, // Add a loading state
};

const getters = {
    allConnections: (state) => state.connections,
};

const actions = {
    async fetchConnections({ commit }){
        try {
            const response = await api.get('/connections');
            commit('setConnections', response.data);
        } catch (error) {
            console.error("Error fetching connections:", error);
        }
    },
};

const mutations = {
    setConnections(state, connections) {
        state.connections = connections;
    },
};

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations,
};