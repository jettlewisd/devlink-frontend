<template>
    <div v-if="selectedUser">
      <h3 class="section-title">User Skills</h3>
      <ul v-if="selectedSkills.length > 0">
        <li v-for="(skill, index) in selectedSkills" :key="index" class="skill-item">
          <span class="skill-name">{{ skill.skillName }}</span>
          <span class="skill-level">({{ skill.proficiencyLevel }})</span>
        </li>
      </ul>
      <p v-else>No skills available</p>
    </div>
  </template>
  
  <script>
  export default {

    props: {
      selectedUser: Object,
    },

    computed: {
        selectedSkills() {
            return this.$store.state.skill.selectedSkills || []; // Default to empty array
        },
    },

    watch: {
        selectedUser(newVal, oldVal) {
            if (newVal && newVal.id && newVal !== oldVal) {
                this.fetchSkillsByUserId(newVal.id);
            }
        },
    },


    methods: {
        async fetchSkillsByUserId(userId) {
            try {
                console.log('Fetching skills for user ID:', userId);
                await this.$store.dispatch('skill/fetchSkillsByUserId', userId);
            } catch (error) {
                console.error('Error fetching skills:', error);
            }
        },
    },


    created() {
      if (this.selectedUser && this.selectedUser.id) {
        console.log('Fetching skills for user ID:', this.selectedUser.id);
        this.fetchSkillsByUserId(this.selectedUser.id);
      }
    },

  };
  </script>
  
  <style scoped>
  .section-title {
    font-size: 1.5em;
    margin-bottom: 1rem;
    font-weight: bold;
  }
  
  .skill-item {
    margin: 0.5rem 0;
    font-size: 1.1em;
  }
  
  .skill-name {
    font-weight: 600;
  }
  
  .skill-level {
    color: #888;
    font-style: italic;
  }
  
  p {
    font-style: italic;
    color: #777;
  }
  </style>
  