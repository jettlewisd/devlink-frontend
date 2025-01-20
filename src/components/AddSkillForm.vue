<template>
  <div class="add-skill-form">
      <h3>Add a New Skill</h3>

      <!-- Skill Name input -->
      <label for="skillName">Skill Name:</label>
      <input 
          type="text"
          id="skill-name"
          v-model="skillName"
          placeholder="Enter skill name"
      />

      <!-- Proficiency Level input -->    
      <label for="proficiencyLevel">Proficiency Level:</label>
      <select 
          id="proficiency-level"
          v-model="proficiencyLevel"
      >
          <option value="">Select Proficiency Level</option>
          <option value="Beginner">Beginner</option>
          <option value="Intermediate">Intermediate</option>
          <option value="Advanced">Advanced</option>
          <option value="Expert">Expert</option>
      </select>

      <!-- Submit Button -->
      <button @click="submitSkill">Add Skill</button>
  </div>
</template>

<script>
export default {
  name: "AddSkillForm",

  data() {
      return {
          skillName: "",
          proficiencyLevel: "",
      };
  },

  methods: {
      submitSkill() {
          // Validate the form input
          if (this.skillName.trim() === "" || this.proficiencyLevel.trim() === "") {
              alert("Please fill out all fields.");
              return;
          }

          // Create a new skill object with the data
          const newSkill = {
              skillName: this.skillName,
              proficiencyLevel: this.proficiencyLevel,
          };

          // Dispatch the action to Vuex to add the skill
          this.$store.dispatch("skill/addSkill", newSkill);

          // Reset form fields after submission
          this.skillName = "";
          this.proficiencyLevel = "";
      },
  },
};
</script>

<style scoped>
.add-skill-form {
background-color: #f9f9f9;
padding: 20px;
border-radius: 8px;
box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
max-width: 500px;
margin: 0 auto;
}

.add-skill-form h3 {
font-size: 1.8rem;
margin-bottom: 20px;
color: #333;
}

.add-skill-form label {
display: block;
font-size: 1rem;
margin: 10px 0 4px;
color: #555;
}

.add-skill-form input,
.add-skill-form select {
width: 100%;
padding: 10px;
font-size: 1rem;
border-radius: 4px;
border: 1px solid #ddd;
margin-bottom: 20px;
box-sizing: border-box;
}

.add-skill-form input:focus,
.add-skill-form select:focus {
border-color: #4CAF50;
outline: none;
}

.add-skill-form button {
width: 100%;
padding: 10px;
background-color: #4CAF50;
color: white;
font-size: 1.2rem;
border: none;
border-radius: 4px;
cursor: pointer;
transition: background-color 0.3s;
}

.add-skill-form button:hover {
background-color: #45a049;
}

.add-skill-form button:disabled {
background-color: #ccc;
cursor: not-allowed;
}
</style>
