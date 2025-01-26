<template>
  <div class="skills-view">
    <h1>Skills</h1>

    <!-- Button to toggle the Add Skill form -->
    <button @click="toggleAddForm" class="add-skill-btn">
      Add Skill
    </button>

    <!-- Conditionally render the AddSkillForm -->
    <AddSkillForm v-if="isAddFormVisible" />

    <!-- Pass 'skills' to the SkillsList component -->
    <SkillsList :skills="skills" @view-skill-details="handleViewDetails" />
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
      // Handle the view details action (you can implement this based on your app flow)
      this.$router.push({ name: "skillDetails", params: { id: skillId } });
    },
  },
};
</script>

<style scoped>
.skills-view {
  padding: 16px;
  background-color: #f9f9f9;
}

.add-skill-btn {
  background-color: #28a745;
  color: white;
  padding: 10px 16px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-bottom: 20px;
}

.add-skill-btn:hover {
  background-color: #218838;
}

h1 {
  font-size: 2rem;
  color: #333;
  text-align: center;
  margin-bottom: 20px;
}
</style>
