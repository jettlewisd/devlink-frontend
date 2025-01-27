<template>
    <div v-if="selectedUser">
      <h3 class="section-title">User Skills</h3>
      <ul v-if="selectedUser.skills && selectedUser.skills.length > 0">
        <li v-for="(skill, index) in selectedUser.skills" :key="index" class="skill-item">
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
      selectedUser: {
        type: Object,
        required: true,
      },
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
  