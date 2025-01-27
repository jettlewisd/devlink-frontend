import UserService from '@/services/UserService';


const state = {
    users: [],               // Stores the list of all users
    selectedUser: null,      // Stores the currently selected user
    loading: false,          // Tracks the loading state
    userError: null, // State to store the error message

};

const getters = {
    allUsers: (state) => state.users,               // Retrieve all users
    selectedUser: (state) => state.selectedUser,    // Retrieve the selected user
};

const mutations = {
    setUsers(state, users) {
        state.users = users; // Update the users array in the state
    },
    setSelectedUser(state, user) {
        state.selectedUser = user; // Update the selected user in the state
    },
    setLoading(state, loading) {
        state.loading = loading; // Update the loading state
    },
    setUserError(state, errorMessage) {
        state.userError = errorMessage; // Set the error message in the state
    },
};

const actions = {
    // Fetch all users
    async fetchUsers({ commit }) {
        try {
            commit('setLoading', true);
            const response = await UserService.fetchAllUsers();
            console.log('API response:', response.data); // Check this log in the browser's console
            commit('setUsers', response.data);
        } catch (error) {
            console.error('Error fetching users:', error);
            throw error; // Optional: rethrow for the component to handle
        } finally {
            commit('setLoading', false);
        }
    },

    // Fetch a single user by ID
    async fetchUserById({ commit }, id) {
        try {
            const response = await UserService.fetchUserById(id);
            commit('setSelectedUser', response.data); // Commit the fetched user to the state
            commit('setUserError', null); // Clear any previous errors

        } catch (error) {
            console.error('Error fetching user by ID:', error);
            
            commit('setSelectedUser', null);
            commit('setUserError', 'User ID is invalid'); // Set error message when user not found


            // throw error; // Optional: rethrow for the component to handle
        }
    },

    // Create a new user
    async createUser({ dispatch }, user) {
        try {
            console.log('Creating user with data:', user); // Debugging line to see the data format
            await UserService.createUser(user);
            await dispatch('fetchUsers'); // Refresh the user list after creation
        } catch (error) {
            console.error('Error creating user:', error);
            throw error; // Optional: rethrow for the component to handle
        }
    },

    // Update an existing user
    async updateUser({ dispatch }, { id, user }) {
        try {
            await UserService.updateUser(id, user);
            await dispatch('fetchUsers'); // Refresh the user list after update
        } catch (error) {
            console.error('Error updating user:', error);
            throw error; // Optional: rethrow for the component to handle
        }
    },

    // Delete a user
    async deleteUser({ dispatch }, id) {
        try {
            await UserService.deleteUser(id);
            await dispatch('fetchUsers'); // Refresh the user list after deletion
        } catch (error) {
            console.error('Error deleting user:', error);
            throw error; // Optional: rethrow for the component to handle
        }
    },

    // Fetch users by skill
    async fetchUsersBySkill({ commit }, skillName) {
        try {
            const response = await UserService.fetchUsersBySkill(skillName);
            commit('setUsers', response.data); // Commit the users matching the skill
        } catch (error) {
            console.error('Error fetching users by skill:', error);
            throw error; // Optional: rethrow for the component to handle
        }
    },

    // Fetch connections for a user
    async fetchConnections({ commit }, userId) {
        try {
            const response = await UserService.fetchConnectionsForUser(userId);
            commit('setUsers', response.data); // Commit the user's connections
        } catch (error) {
            console.error('Error fetching user connections:', error);
            throw error; // Optional: rethrow for the component to handle
        }
    },

    // Fetch recommended connections for a user
    async fetchRecommendedConnections({ commit }, userId) {
        try {
            const response = await UserService.getRecommendedConnectionsForUser(userId);
            commit('setUsers', response.data); // Commit the recommended connections
        } catch (error) {
            console.error('Error fetching recommended connections:', error);
            throw error; // Optional: rethrow for the component to handle
        }
    },
};


export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations,
};
