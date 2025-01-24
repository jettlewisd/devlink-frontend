<template>
    <div class="home-view">
     

      <section class="main-content">
        <h1>Welcome to DevLink</h1>
  
        <!-- Placeholder for ProjectList -->
        <ProjectList :projects="projects" @view-project-details="handleViewDetails" />
  
        <!-- Placeholder for UserList -->
        <UserList :users="users" @view-user-profile="handleViewProfile" />
      </section>
  
    </div>
  </template>
  
  <script>
  import ProjectList from '../components/ProjectList.vue';
  import UserList from '../components/UserList.vue';
  
  export default {
    name: 'HomeView',
    components: {
      ProjectList,
      UserList
    },
    computed: {
      projects() {
        return this.$store.state.project.projects; // Get the list of projects from Vuex store
      },
      users() {
        return this.$store.state.user.users; // Get the list of users from Vuex store
      }
    },
    mounted() {
    this.$store.dispatch('project/fetchProjects');
    this.$store.dispatch("user/fetchUsers");  // Fetch users on component mount
  },
    methods: {
      handleViewDetails(projectId) {
        this.$router.push({ name: 'projectDetails', params: { id: projectId } });
      },
      handleViewProfile(userId) {
        this.$router.push({ name: 'profile', params: { id: userId } });
      }
    }
  };
  </script>
  
  <style scoped>
  .home-view {
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  
  .main-content {
    padding: 2rem;
  }
  
  h1 {
    font-size: 2rem;
    color: #333;
    margin-bottom: 20px;
  }
  </style>
