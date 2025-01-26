import SkillService from '@/services/SkillService';

const state = {
  skills: [],
  selectedSkill: null,
  selectedSkills: null,
  userHasSkill: null,  // New state for storing the boolean result of userHasSkill
  loading: false, // Added loading state to track API request status
};

const getters = {
  allSkills: (state) => state.skills, // Get all skills
  getSelectedSkill: (state) => state.selectedSkill, // Get selected skill
  getSelectedSkills: (state) => state.selectedSkills, // Get selected skill(s)
  getUserHasSkill: (state) => state.userHasSkill, // Get userHasSkill
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
  setUserHasSkill(state, userHasSkill) {
    state.userHasSkill = userHasSkill;
  },
  setLoading(state, loading) {
    state.loading = loading;
  },
  addSkill(state, skill) {
    state.skills.push(skill);
  },
};

const actions = {
  async fetchSkills({ commit }) {
    try {
      commit('setLoading', true);
      const response = await SkillService.fetchAllSkills();
      console.log('API response:', response.data);
      commit('setSkills', response.data);
    } catch (error) {
      console.log('Error fetching skills:', error);
      throw error;
    } finally {
      commit('setLoading', false);
    }
  },

  async fetchSkillById({ commit }, id) {
    try {
      commit('setLoading', true);
      const response = await SkillService.fetchSkillById(id);
      console.log('API response:', response.data);
      commit('setSelectedSkill', response.data);
    } catch (error) {
      console.log('Error fetching skill by ID', error);
      throw error;
    } finally {
      commit('setLoading', false);
    }
  },

  async fetchSkillsByUserId({ commit }, userId) {
    try {
      commit('setLoading', true);
      const response = await SkillService.fetchSkillsByUserId(userId);
      console.log('API response:', response.data);
      commit('setSelectedSkills', response.data);
    } catch (error) {
      console.log('Error fetching skills by User ID', error);
      throw error;
    } finally {
      commit('setLoading', false);
    }
  },

  async createSkill({ commit }, skill) {
    try {
      const response = await SkillService.createSkill(skill);
      console.log('Backend Response:', response); // Log full response
      console.log('Response Data:', response.data); // Log backend data
      commit('addSkill', response.data);  // Add the new skill to the Vuex store
    } catch (error) {
      console.log('Error creating skill:', error);
    }
  },
  
  async updateSkill({ dispatch }, { id, skill }) {
    try {
      await SkillService.updateSkill(id, skill);
      await dispatch('fetchSkills');
    } catch (error) {
      console.log('Error updating skill:', error);
      throw error;
    }
  },

  async deleteSkill({ dispatch }, id) {
    try {
      await SkillService.deleteSkill(id);
      await dispatch('fetchSkills');
    } catch (error) {
      console.log('Error deleting skill:', error);
      throw error;
    }
  },

  async fetchSkillsByProficiency({ commit }, proficiencyLevel) {
    try {
      commit('setLoading', true);
      const response = await SkillService.fetchSkillsByProficiency(proficiencyLevel);
      console.log('API response:', response.data);
      commit('setSkills', response.data);
    } catch (error) {
      console.log('Error fetching skills by proficiency level', error);
      throw error;
    } finally {
      commit('setLoading', false);
    }
  },

  async userHasSkill({ commit }, { userId, skillName }) {
    try {
      commit('setLoading', true);
      const response = await SkillService.userHasSkill(userId, skillName);
      console.log('API response:', response.data);
      commit('setUserHasSkill', response.data);
    } catch (error) {
      console.log('Error fetching skill by User ID and skill name', error);
      throw error;
    } finally {
      commit('setLoading', false);
    }
  }
};

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions,
};
