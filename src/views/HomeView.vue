<template>
    <div class="home-view">
     

      <section class="main-content">

        <h1>Welcome to DevLink</h1>
        <p>DevLink is a platform for developers to showcase their skills, connect with others, and collaborate on projects.
           Build your profile, list your expertise, and find like-minded professionals to grow your network.</p>
        <p>This app was built using Vue.js for the frontend, Spring Boot with Java for the backend, 
          PostgreSQL for the database, and Axios for API communication. Upcoming features include user 
          authentication, connections, and posting capabilities!</p>

      </section>
  
    </div>
  </template>
  
  <script>
  
  export default {
    name: 'HomeView',
    
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
