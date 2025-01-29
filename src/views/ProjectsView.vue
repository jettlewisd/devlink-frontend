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
  padding: 2rem;
  background-color: #031d44; /* Deep blue background to match HomeView */
  color: #e0e0e0; /* Light grey text for readability */
  font-family: 'Poppins', sans-serif; /* Consistent font */
}

.create-project-btn {
  background-color: #c39e29; /* Maze yellow button */
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  margin-bottom: 30px;
  font-size: 1rem;
  transition: background-color 0.3s ease, transform 0.3s ease; /* Smooth transitions */
}

.create-project-btn:hover {
  background-color: #f1c40f; /* Lighter yellow on hover */
  transform: scale(1.05); /* Slight scaling effect on hover */
}

h1 {
  font-size: 2.5rem;
  color: #f4f4f4; /* Lighter color for the heading */
  text-align: center;
  margin-bottom: 30px;
}

</style>
