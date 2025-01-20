<template>
  <div class="projects-view">
      <AppHeader /> <!-- Include the AppHeader -->
      
      <!-- Add a section to show all projects -->
      <h2>Projects</h2>
      <ProjectList /> <!-- The ProjectList component will display the projects -->

      <AppFooter /> <!-- Include the AppFooter -->
  </div>
</template>

<script>
// Import the components and the store
import AppHeader from '@/components/AppHeader.vue';
import AppFooter from '@/components/AppFooter.vue';
import ProjectList from '@/components/ProjectList.vue';

export default {
  name: 'ProjectsView',
  
  components: {
      AppHeader,
      AppFooter,
      ProjectList,
  },

  created() {
      // Dispatch the action to fetch projects when the component is created
      this.$store.dispatch('project/fetchProjects');
  },
};
</script>

<style scoped>
/* You can add specific styles here if needed */
</style>
