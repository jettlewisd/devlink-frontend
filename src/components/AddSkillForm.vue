<template>
    <div class="add-skill-form">
        <h3>Add a New Skill</h3>

        <!-- Skill name input -->
        <label for="skillName">Skill Name:</label>
        <input 
            type="text"
            id="skill-name"
            v-model="skillName"
            placeholder="Enter skill name"
        />

        <!-- Proficiency level input -->    
        <label for="proficiency-level">Proficiency Level:</label>
        <select v-model="proficiencyLevel">
            <option value="beginner">Beginner</option>
            <option value="intermediate">Intermediate</option>
            <option value="advanced">Advanced</option>
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
            proficiencyLevel: "beginner", // default value for proficiency level 
        };
    },

    methods: {
        submitSkill() {
            if (this.skillName.trim() === "") {
                alert("Please enter a skill name.");
                return;
            }

            // Emit the skill and proficiency level to the parent component
            this.$emit("add-skill", {
                skillName: this.skillName,
                proficiencyLevel: this.proficiencyLevel,
            });

            // reset the form after submission
            this.skillName= "";
            this.proficiencyLevel= "beginner";
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
  max-width: 400px;
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
