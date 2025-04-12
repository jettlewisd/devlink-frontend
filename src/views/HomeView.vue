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
      return this.$store.state.project.projects; 
    },
    users() {
      return this.$store.state.user.users; 
    }
  },
  mounted() {
    this.$store.dispatch('project/fetchProjects');
    this.$store.dispatch("user/fetchUsers");  
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
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap');

/* Deep Blue, Grey, and Maze Yellow Theme */
.home-view {
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: #031d44; /* Deep Blue background */
  min-height: 100vh;
  padding: 3rem 1.5rem;
  font-family: 'Poppins', sans-serif; 
  color: #e0e0e0;
}

.main-content {
  background: linear-gradient(145deg, #2f3b53, #1f2738); /* Dark grey/blue gradient */
  border-radius: 20px;
  box-shadow: 0 4px 30px rgba(0, 0, 0, 0.4); 
  padding: 4rem 3rem;
  width: 100%;
  max-width: 900px;
  margin-top: 100px;
  text-align: center;
}

h1 {
  font-size: 4rem;
  font-weight: 600;
  color: #c39e29; /* Maze Yellow for heading to pop */
  text-transform: uppercase;
  margin-bottom: 25px;
  letter-spacing: 2px;
}

p {
  font-size: 1.5rem;
  color: #d1d1d1; 
  line-height: 1.6;
  margin-bottom: 1.5rem;
  max-width: 800px;
  margin-left: auto;
  margin-right: auto;
}

p:last-of-type {
  margin-bottom: 0;
}

a {
  color: #c39e29; 
  font-weight: 500;
  transition: color 0.3s ease;
}

a:hover {
  color: #e4c23d; 
  text-decoration: underline;
}

/* Responsiveness for Mobile */
@media (max-width: 768px) {
  .home-view {
    padding: 2rem;
  }

  h1 {
    font-size: 2.5rem;
  }

  .main-content {
    padding: 2rem;
  }

  p {
    font-size: 1.2rem;
  }
}
</style>
