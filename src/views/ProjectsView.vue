<template>
  <div class="projects-view">  
    <h1>Projects</h1>

    <button @click="toggleCreateForm" class="create-project-btn">
      Create Project
    </button>

    <CreateProjectForm v-if="isCreateFormVisible" />

    <ProjectList :projects="projects" @view-project-details="handleViewDetails" />
  </div>
</template>

<script>
import ProjectList from "@/components/ProjectList.vue";
import CreateProjectForm from "@/components/CreateProjectForm.vue";

export default {
  name: "ProjectsView",
  components: {
    ProjectList,
    CreateProjectForm
  },
  data() {
    return {
      isCreateFormVisible: false,  
    };
  },
  computed: {
    projects() {
      return this.$store.state.project.projects; 
    },
  },
  mounted() {
    this.$store.dispatch("project/fetchProjects");  
  },
  methods: {
    toggleCreateForm() {
      this.isCreateFormVisible = !this.isCreateFormVisible; 
    },
    handleViewDetails(projectId) {
      this.$router.push({ name: "projectDetails", params: { id: projectId } });
    },
  },
};
</script>

<style scoped>
.projects-view {
  padding: 2rem;
  background-color: var(--primary-bg-color);
  color: var(--heading-color);
  font-family: 'Poppins', sans-serif;
}

.create-project-btn {
  background-color: var(--button-bg-color);
  color: var(--button-text-color);
  padding: 12px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  margin-bottom: 30px;
  font-size: 1rem;
  transition: background-color 0.3s ease, transform 0.3s ease;
}

.create-project-btn:hover {
  background-color: var(--button-bg-color);
  transform: scale(1.05);
}

h1 {
  font-size: 2.5rem;
  color: var(--heading-color);
  text-align: center;
  margin-bottom: 30px;
}
</style>
