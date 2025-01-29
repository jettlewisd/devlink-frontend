<template>
    <div v-if="selectedUser" class="user-skills">
      <h3 class="section-title">User Skills:</h3>
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
          console.log("Fetching skills for user ID:", userId);
          await this.$store.dispatch("skill/fetchSkillsByUserId", userId);
        } catch (error) {
          console.error("Error fetching skills:", error);
        }
      },
    },
  
    created() {
      if (this.selectedUser && this.selectedUser.id) {
        console.log("Fetching skills for user ID:", this.selectedUser.id);
        this.fetchSkillsByUserId(this.selectedUser.id);
      }
    },
  };
  </script>
  
  <style scoped>
  /* Importing Poppins font */
  @import url("https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap");
  
  .user-skills {
    background: linear-gradient(145deg, #2f3b53, #1f2738); /* Dark blue-grey gradient */
    padding: 1.5rem;
    border-radius: 12px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
    color: #e0e0e0;
    font-family: "Poppins", sans-serif;
    max-width: 400px;
    margin: 20px auto;
    text-align: center;
  }
  
  /* Section Title */
  .section-title {
    font-size: 1.8rem;
    font-weight: 600;
    color: #c39e29; /* Maze Yellow */
    margin-bottom: 1rem;
    letter-spacing: 1px;
  }
  
  /* Skill List */
  .skill-item {
    background-color: rgba(255, 255, 255, 0.1);
    padding: 0.8rem;
    margin: 0.5rem 0;
    border-radius: 8px;
    display: flex;
    justify-content: space-between;
    font-size: 1.1rem;
    color: #ffffff;
  }
  
  /* Skill Name */
  .skill-name {
    font-weight: 600;
    text-transform: uppercase;
  }
  
  /* Skill Level */
  .skill-level {
    color: #c39e29; /* Maze Yellow */
    font-style: italic;
  }
  
  /* No Skills Message */
  p {
    font-style: italic;
    color: #b0b0b0;
    margin-top: 10px;
  }
  </style>
  