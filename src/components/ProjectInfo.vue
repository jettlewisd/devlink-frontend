<template>
    <div class="project-info">
      <h2>{{ project.name }}</h2>
      <p>{{ project.description }}</p>
      <p><strong>Start Date:</strong> {{ project.startDate }}</p>
      <p><strong>End Date:</strong> {{ project.endDate }}</p>
      <p><strong>Created by (User ID):</strong> {{ project.createdBy }}</p>
    </div>
  </template> 
  
  <script>
  export default {
    name: 'ProjectInfo',
  
    /**
     * Props:
     * - project (Object): The project details passed from the parent component.
     *   This object contains the name, description, start date, end date, and creator ID.
     */
    props: {
      project: {
        type: Object,
        required: true
      }
    }
  };
  </script>
  
  <style scoped>
  .project-info {
    background-color: var(--secondary-bg-color);
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
    margin-bottom: 20px;
  }
  
  .project-info h2 {
    font-size: 2rem;
    margin-bottom: 10px;
    color: var(--heading-color);
  }
  
  .project-info p {
    font-size: 1rem;
    margin: 8px 0;
    color: var(--text-color);
  }
  
  .project-info strong {
    color: var(--heading-color);
  }
</style>
