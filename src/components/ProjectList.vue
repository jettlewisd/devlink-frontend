<template>
  <div class="project-list">
    <!-- Check if there are projects to display -->
    <div v-if="projects.length > 0">
      <!-- Loop through each project and display a ProjectCard -->
      <ProjectCard
        v-for="project in projects"
        :key="project.id"
        :project="project"
        @view-details="handleViewDetails"
      />
    </div>

    <!-- Show a message if there are no projects -->
    <div v-else class="no-projects">
      <p>No projects to display.</p>
    </div>
  </div>
</template>

<script>
import ProjectCard from "./ProjectCard.vue";

export default {
  name: "ProjectList",

  components: {
    ProjectCard,
  },

  props: {
    projects: {
      type: Array, // The prop expects an array of projects
      required: true, // It's mandatory for the parent to pass this prop
    },
  },

  methods: {
    handleViewDetails(projectId) {
      // Emits a custom event with the ID of the selected project
      this.$emit("view-project-details", projectId);
    },
  },
};
</script>
<style scoped>
  .project-list {
    margin: 16px 0;
    padding: 16px;
    border-radius: 8px;
    background-color: var(--primary-bg-color);
    color: var(--text-color);
  }

  .project-list h2 {
    font-size: 1.8rem;
    color: var(--button-bg-color);
    margin-bottom: 16px;
    text-align: center;
  }

  .no-projects {
    text-align: center;
    color: #777;
    font-size: 1rem;
    margin-top: 16px;
  }
</style>

