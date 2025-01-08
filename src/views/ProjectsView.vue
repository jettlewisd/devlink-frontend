<template>
    <div class="projects-view">
      <AppHeader />
  
      <section class="projects-list">
        <h1>Projects</h1>
        <ProjectList />
        <CreateProjectForm />
      </section>
  
      <AppFooter />
    </div>
  </template>
  
  <script>
  import AppHeader from '../components/AppHeader.vue';
  import AppFooter from '../components/AppFooter.vue';
  import ProjectList from '../components/ProjectList.vue';
  import CreateProjectForm from '../components/CreateProjectForm.vue';
  
  export default {
    name: 'ProjectsView',
    components: {
      AppHeader,
      AppFooter,
      ProjectList,
      CreateProjectForm,
    },
  };
  </script>
  
  <style scoped>
  .projects-view {
    padding: 2rem;
  }
  .projects-list {
    display: flex;
    flex-direction: column;
    gap: 1.5rem;
  }
  </style>
  