import api from "@/api";

const state = {
    posts: [],
};

const getters = {
    allPosts: (state) => state.posts, 
};

const actions = {
    async fetchPosts({ commit }) {
        try {
            const response = await api.get('/posts');
            commit('setPosts', response.data);
        } catch (error) {
            console.error("Error fetching posts:", error);
        }
    },
};

const mutations = {
    setPosts(state, posts) {
        state.posts = posts;
    },
};

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations,
};