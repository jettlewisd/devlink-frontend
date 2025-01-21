import ProjectService from '@/services/ProjectService';

const state = {
    projects: [],          // Stores the list of all projects
    selectedProject: null, // Stores the currently selected project
    loading: false,        // Tracks the loading state
};

const getters = {
    allProjects: (state) => state.projects,          // Retrieve all projects
    selectedProject: (state) => state.selectedProject, // Retrieve the selected project
};

const actions = {
    // Fetch all projects
    async fetchProjects({ commit }) {
        try {
            commit('setLoading', true);
            const response = await ProjectService.fetchAllProjects();
            console.log('API response:', response.data); // Check this log in the browser's console
            commit('setProjects', response.data);
        } catch (error) {
            console.error('Error fetching projects:', error);
        } finally {
            commit('setLoading', false);
        }
    },
    

    // Fetch a single project by ID
    async fetchProjectById({ commit }, id) {
        try {
            const response = await ProjectService.fetchProjectById(id); // Updated method name
            commit('setSelectedProject', response.data); // Commit the fetched project to the state
        } catch (error) {
            console.error('Error fetching project by ID:', error);
            throw error; // Optional: rethrow for the component to handle
        }
    },

    // Create a new project
    async createProject({ dispatch }, project) {
        try {
            console.log('Creating project with data:', project);  // Debugging line to see the data format
            await ProjectService.createProject(project);
            await dispatch('fetchProjects'); // Refresh the project list after creation
        } catch (error) {
            console.error('Error creating project:', error);
            throw error; // Optional: rethrow for the component to handle
        }
    },

    // Update an existing project
    async updateProject({ dispatch }, { id, project }) {
        try {
            await ProjectService.updateProject(id, project);
            await dispatch('fetchProjects'); // Refresh the project list after update
        } catch (error) {
            console.error('Error updating project:', error);
            throw error; // Optional: rethrow for the component to handle
        }
    },

    // Delete a project
    async deleteProject({ dispatch }, id) {
        try {
            await ProjectService.deleteProject(id);
            await dispatch('fetchProjects'); // Refresh the project list after deletion
        } catch (error) {
            console.error('Error deleting project:', error);
            throw error; // Optional: rethrow for the component to handle
        }
    },

    // Fetch projects by creator
    async fetchProjectsByCreator({ commit }, createdBy) {
        try {
            const response = await ProjectService.fetchProjectsByCreator(createdBy); // Updated method name
            commit('setProjects', response.data); // Commit the projects created by the user
        } catch (error) {
            console.error('Error fetching projects by creator:', error);
            throw error; // Optional: rethrow for the component to handle
        }
    },
};

const mutations = {
    setProjects(state, projects) {
        state.projects = projects; // Update the projects array in the state
    },
    setSelectedProject(state, project) {
        state.selectedProject = project; // Update the selected project in the state
    },
    setLoading(state, isLoading) {
        state.loading = isLoading; // Update the loading state
    },
};

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations,
};
