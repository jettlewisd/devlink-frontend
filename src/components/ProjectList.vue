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
  /* -------------------------
     Project List Container
     ------------------------- */
  .project-list {
    margin: 16px 0; /* Adds spacing around the component */
    padding: 16px; /* Adds padding inside the container */
    border: 1px solid #ddd; /* Adds a light border */
    border-radius: 8px; /* Rounds the corners */
    background-color: #f9f9f9; /* Light gray background for distinction */
  }
  
  /* -------------------------
     Heading Styling
     ------------------------- */
  .project-list h2 {
    font-size: 1.8rem; /* Larger font size for prominence */
    color: #333; /* Dark gray for readability */
    margin-bottom: 16px; /* Adds spacing below the heading */
    text-align: center; /* Centers the heading */
  }
  
  /* -------------------------
     No Projects Message
     ------------------------- */
  .no-projects {
    text-align: center; /* Centers the message text */
    color: #777; /* Light gray text for subtle emphasis */
    font-size: 1rem; /* Standard font size */
    margin-top: 16px; /* Adds spacing above the message */
  }
  </style>
  