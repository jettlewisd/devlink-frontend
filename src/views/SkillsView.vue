<template>
  <div class="skills-view">
    <section class="main-content">
      <h1>Skills</h1>
      <p>Showcase your skills and expertise. Add new skills to your profile and let others see what you bring to the table.</p>

      <button @click="toggleAddForm" class="add-skill-btn">
        Add Skill
      </button>

      <AddSkillForm v-if="isAddFormVisible" />

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
      isAddFormVisible: false, 
    };
  },
  computed: {
    skills() {
      return this.$store.state.skill.skills;
    },
  },
  mounted() {
    this.$store.dispatch("skill/fetchSkills"); 
  },
  methods: {
    toggleAddForm() {
      this.isAddFormVisible = !this.isAddFormVisible; 
    },
    handleViewDetails(skillId) {
      this.$router.push({ name: "skillDetails", params: { id: skillId } });
    },
  },
};
</script>

<style scoped>
.skills-view {
  background-color: var(--primary-bg-color);
  min-height: 100vh;
  padding: 3rem 1.5rem;
  font-family: 'Poppins', sans-serif;
  color: var(--text-color);
}

.main-content {
  margin-top: 1rem;
  background: linear-gradient(145deg, var(--secondary-bg-color), #1f2738);
  border-radius: 20px;
  padding: 3rem;
  box-shadow: 0 4px 30px rgba(0, 0, 0, 0.4);
  text-align: center;
}

h1 {
  font-size: 4rem;
  font-weight: 600;
  color: var(--button-text-color); 
  margin-bottom: 25px;
  letter-spacing: 2px;
}

p {
  font-size: 1.5rem;
  color: var(--text-color);
  line-height: 1.6;
  margin-bottom: 1.5rem;
  max-width: 800px;
  margin-left: auto;
  margin-right: auto;
}

.add-skill-btn {
  background-color: var(--button-bg-color);
  color: var(--button-text-color);  
  font-weight: 600;
  padding: 12px 20px;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background 0.3s ease;
  font-size: 1.2rem;
  margin-bottom: 2rem;
}

.add-skill-btn:hover {
  background-color: var(--border-color);  
}

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
