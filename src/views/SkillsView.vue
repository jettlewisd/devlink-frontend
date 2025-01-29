<template>
  <div class="skills-view">
    <section class="main-content">
      <h1>Skills</h1>
      <p>Showcase your skills and expertise. Add new skills to your profile and let others see what you bring to the table.</p>

      <!-- Button to toggle the Add Skill form -->
      <button @click="toggleAddForm" class="add-skill-btn">
        Add Skill
      </button>

      <!-- Conditionally render the AddSkillForm -->
      <AddSkillForm v-if="isAddFormVisible" />

      <!-- Pass 'skills' to the SkillsList component -->
      <SkillsList :skills="skills" @view-skill-details="handleViewDetails" />
    </section>
  </div>
</template>

<script>
import SkillsList from "@/components/SkillList.vue";
import AddSkillForm from "@/components/AddSkillForm.vue";

export default {
  name: "SkillsView",
  components: {
    SkillsList,
    AddSkillForm,
  },
  data() {
    return {
      isAddFormVisible: false, // Toggle the visibility of the Add Skill form
    };
  },
  computed: {
    skills() {
      return this.$store.state.skill.skills; // Get the list of skills from Vuex store
    },
  },
  mounted() {
    this.$store.dispatch("skill/fetchSkills"); // Fetch skills on component mount
  },
  methods: {
    toggleAddForm() {
      this.isAddFormVisible = !this.isAddFormVisible; // Toggle the Add Skill form
    },
    handleViewDetails(skillId) {
      this.$router.push({ name: "skillDetails", params: { id: skillId } });
    },
  },
};
</script>

<style scoped>
/* Importing Poppins font */
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap');

/* Deep Blue, Grey, and Maze Yellow Theme */
.skills-view {
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: #031d44; /* Deep Blue background (matches HomeView) */
  min-height: 100vh;
  padding: 3rem 1.5rem;
  font-family: 'Poppins', sans-serif;
  color: #e0e0e0; /* Light grey text */
}

.main-content {
  background: linear-gradient(145deg, #2f3b53, #1f2738); /* Dark grey/blue gradient */
  border-radius: 20px;
  box-shadow: 0 4px 30px rgba(0, 0, 0, 0.4); /* Stronger shadow */
  padding: 4rem 3rem;
  width: 100%;
  max-width: 900px;
  margin-top: 100px;
  text-align: center;
}

h1 {
  font-size: 4rem;
  font-weight: 600;
  color: #c39e29; /* Maze Yellow for heading */
  text-transform: uppercase;
  margin-bottom: 25px;
  letter-spacing: 2px;
}

p {
  font-size: 1.5rem;
  color: #d1d1d1; /* Lighter grey for body text */
  line-height: 1.6;
  margin-bottom: 1.5rem;
  max-width: 800px;
  margin-left: auto;
  margin-right: auto;
}

.add-skill-btn {
  background-color: #c39e29; /* Maze Yellow */
  color: #031d44; /* Deep Blue text for contrast */
  font-weight: 600;
  padding: 12px 20px;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background 0.3s ease;
  font-size: 1.2rem;
}

.add-skill-btn:hover {
  background-color: #e4c23d; /* Brighter yellow on hover */
}

/* Responsiveness for Mobile */
@media (max-width: 768px) {
  .skills-view {
    padding: 2rem;
  }

  h1 {
    font-size: 2.5rem;
  }

  .main-content {
    padding: 2rem;
  }

  p {
    font-size: 1.2rem;
  }
}
</style>
