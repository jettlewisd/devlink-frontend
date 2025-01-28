<template>
    <div v-if="selectedUser">
      <h3 class="section-title">User Projects</h3>
      <ul v-if="selectedUser.projects && selectedUser.projects.length > 0">
        <li v-for="(project, index) in selectedUser.projects" :key="index" class="project-item">
          <div class="project-name">{{ project.name }}</div>
          <div class="project-description">{{ project.description }}</div>
          <div class="project-dates">
            <span class="start-date">Start: {{ formatDate(project.startDate) }}</span>
            <span v-if="project.endDate" class="end-date">End: {{ formatDate(project.endDate) }}</span>
          </div>
        </li>
      </ul>
      <p v-else>No projects available</p>
    </div>
  </template>
  
  <script>

  export default {
    props: {
      selectedUser: {
        type: Object,
        required: true,
      },
    },

    methods: {
      formatDate(date) {
        const options = { year: 'numeric', month: 'long', day: 'numeric' };
        return new Date(date).toLocaleDateString(undefined, options);
      },
    },
    
  };
  </script>
  
  <style scoped>
  .section-title {
    font-size: 1.5em;
    margin-bottom: 1rem;
    font-weight: bold;
  }
  
  .project-item {
    margin: 1rem 0;
    font-size: 1.1em;
    background-color: #f9f9f9;
    padding: 1rem;
    border-radius: 5px;
    box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
  }
  
  .project-name {
    font-weight: 600;
    font-size: 1.2em;
  }
  
  .project-description {
    font-size: 1em;
    color: #555;
  }
  
  .project-dates {
    margin-top: 0.5rem;
    font-size: 0.9em;
  }
  
  .start-date, .end-date {
    margin-right: 1rem;
    color: #888;
  }
  
  p {
    font-style: italic;
    color: #777;
  }
  </style>
  