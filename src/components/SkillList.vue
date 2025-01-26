<template>
    <div class="skills-list">
      <h2>Skills</h2>
    
      <!-- Check if there are skills to display -->
      <div v-if="skills.length > 0">
        <!-- Loop through each skill and display its name and proficiency -->
        <ul>
          <li v-for="skill in skills" :key="skill.id">
            <div>
              <strong>{{ skill.name }}</strong> - 
              <span>{{ formatProficiency(skill.proficiency) }}</span>
            </div>
          </li>
        </ul>
      </div>
    
      <!-- Show a message if there are no skills -->
      <div v-else class="no-skills">
        <p>No skills to display.</p>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'SkillsList',

    props: {
      skills: {
        type: Array,
        required: true, // Accepts an array of skills as a prop
      },
    },

    methods: {
      // Format proficiency to display more clearly (e.g., Beginner, Intermediate, Advanced)
      formatProficiency(proficiency) {
        const proficiencyLevels = {
          '1': 'Beginner',
          '2': 'Intermediate',
          '3': 'Advanced'
        };
        return proficiencyLevels[proficiency] || 'Unknown'; // Default to 'Unknown' if proficiency level is not found
      }
    },
  };
  </script>
  
  <style scoped>
  .skills-list {
    padding: 20px;
  }
  
  .no-skills {
    color: #999;
    font-style: italic;
  }
  
  li {
    margin: 10px 0;
  }
  
  strong {
    font-weight: bold;
  }
  </style>
  