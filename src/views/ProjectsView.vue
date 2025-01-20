<template>
  <div class="projects-view">
    <AppHeader /> <!-- Include the AppHeader -->

    <!-- Add a section to show all projects -->
    <h2>Projects</h2>
    <!-- Show a message if no projects are available -->
    <ProjectList /> <!-- The ProjectList component will display the projects -->

    <AppFooter /> <!-- Include the AppFooter -->
  </div>
</template>

<script>
// Import the components and the store
import AppHeader from '@/components/AppHeader.vue';
import AppFooter from '@/components/AppFooter.vue';
import ProjectList from '@/components/ProjectList.vue';
import { mapActions } from 'vuex'; // mapActions to dispatch actions

export default {
  name: 'ProjectsView',
  
  components: {
    AppHeader,
    AppFooter,
    ProjectList,
  },

  created() {
    // Dispatch the action to fetch projects when the component is created
    this.fetchProjects();
  },

  methods: {
    ...mapActions('projects', ['fetchProjects']), // Map the fetchProjects action from the store
  },
};
</script>

<style scoped>
/* You can add specific styles here if needed */
</style>
