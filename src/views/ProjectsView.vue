<template>
  <div class="projects-view">  
    <h1>Projects</h1>

    <!-- Button to toggle the Create Project form -->
    <button @click="toggleCreateForm" class="create-project-btn">
      Create Project
    </button>

    <!-- Conditionally render the CreateProjectForm --> 
    <CreateProjectForm v-if="isCreateFormVisible" />

    <!-- Pass 'projects' to the ProjectList component -->
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
      isCreateFormVisible: false,  // Toggle the visibility of the create project form
    };
  },
  computed: {
    projects() {
      return this.$store.state.project.projects;  // Get the list of projects from Vuex store
    },
  },
  mounted() {
    this.$store.dispatch("project/fetchProjects");  // Fetch projects on component mount
  },
  methods: {
    toggleCreateForm() {
      this.isCreateFormVisible = !this.isCreateFormVisible;  // Toggle the create project form
    },
    handleViewDetails(projectId) {
      // Handle the view details action (you can implement this based on your app flow)
      this.$router.push({ name: "projectDetails", params: { id: projectId } });
    },
  },
};
</script>

<style scoped>
.projects-view {
  padding: 16px;
  background-color: #f4f4f4;
}

.create-project-btn {
  background-color: #007bff;
  color: white;
  padding: 10px 16px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-bottom: 20px;
}

.create-project-btn:hover {
  background-color: #0056b3;
}

h1 {
  font-size: 2rem;
  color: #333;
  text-align: center;
  margin-bottom: 20px;
}
</style>
