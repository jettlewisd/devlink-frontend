<template>
    <form @submit.prevent="submitSkill">
      <div>
        <label for="skillName">Skill Name</label>
        <input 
          type="text" 
          v-model="skill.skillName" 
          id="skillName" 
          required 
          placeholder="Enter the skill name"
        />
      </div>
  
      <div>
        <label for="proficiencyLevel">Proficiency Level</label>
        <input 
          type="text" 
          v-model="skill.proficiencyLevel" 
          id="proficiencyLevel" 
          required 
          placeholder="Enter proficiency level (e.g., Beginner, Expert)"
        />
      </div>
  
      <div>
        <label for="userId">User ID</label>
        <input 
          type="number" 
          v-model="skill.userId" 
          id="userId" 
          required 
          placeholder="Enter your user ID"
        />
      </div>
  
      <button type="submit">Add Skill</button>
    </form>
  </template>
  
  <script>
  export default {
    data() {
      return {
        skill: {
          skillName: '',
          proficiencyLevel: '',
          userId: null, 
        }
      };
    },
    methods: {
      submitSkill() {
        // Dispatch the action to create the skill, passing the skill data
        this.$store.dispatch('skill/createSkill', this.skill);
        
        // Reset form after submission
        this.skill = { skillName: '', proficiencyLevel: '', userId: null };
      }
    }
  };
  </script>
  
  
  <style scoped>
form {
  max-width: 400px;
  margin: 20px auto;
  padding: 20px;
  border: 1px solid var(--border-color);
  border-radius: 8px;
  background-color: var(--secondary-bg-color);
}

label {
  display: block;
  margin-bottom: 8px;
  font-weight: bold;
  color: var(--text-color);
}

input {
  width: 100%;
  padding: 8px;
  margin-bottom: 20px;
  border: 1px solid var(--border-color);
  border-radius: 4px;
  background-color: var(--input-bg-color);
  color: var(--input-text-color);
}

button {
  padding: 10px 20px;
  background-color: var(--button-bg-color);
  color: var(--button-text-color);
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

button:hover {
  background-color: #0f3f5f;
}
</style>

  
  