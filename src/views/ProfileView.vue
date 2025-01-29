<template>
  <div class="profile-view">
    <div class="input-container">
      <input v-model="userId" @input="fetchUser" placeholder="Enter User ID" type="text" />
    </div>

    <!-- Display error message if user is not found -->
    <div v-if="userError" class="error-message">
      <p>{{ userError }}</p>
    </div>

    <!-- Show the user profile, skills, and projects if the user exists -->
    <div v-if="selectedUser" class="profile-container">
      <UserProfileInfo :selectedUser="selectedUser" />
      <UserSkills :selectedUser="selectedUser" />
      <UserProjects :selectedUser="selectedUser" />
    </div>
  </div>
</template>

<script>
import UserProfileInfo from '@/components/UserProfileInfo.vue';
import UserSkills from '@/components/UserSkills.vue';
import UserProjects from '@/components/UserProjects.vue';

export default {
  components: {
    UserProfileInfo,
    UserSkills,
    UserProjects,
  },
  data() {
    return {
      userId: '',
    };
  },
  computed: { 
    selectedUser() {
      return this.$store.state.user.selectedUser;
    },
    userError() {
      return this.$store.state.user.userError; // Access the error message from the store
    },
  },
  methods: {
    async fetchUser() {
      if (this.userId) {
        await this.$store.dispatch('user/fetchUserById', this.userId);
      }
    },
  },
};
</script>

<style scoped>
/* Deep Blue, Grey, and Maze Yellow Theme */
.profile-view {
  background-color: #031d44; /* Deep Blue background */
  min-height: 100vh;
  padding: 3rem 1.5rem;
  font-family: 'Poppins', sans-serif; /* Poppins font */
  color: #e0e0e0; /* Light grey text */
}

.input-container {
  text-align: center;
  margin-top: 2rem;
}

input {
  padding: 0.75rem;
  font-size: 1.2rem;
  border: 1px solid #555;
  border-radius: 10px;
  background-color: #2f3b53; /* Dark grey background */
  color: #d1d1d1;
  width: 100%;
  max-width: 350px;
  transition: background-color 0.3s ease;
}

input:focus {
  outline: none;
  background-color: #1f2738; /* Darker grey when focused */
}

.error-message {
  color: #e74c3c; /* Red color for error messages */
  font-size: 1.1rem;
  text-align: center;
  margin-top: 1.5rem;
}

.profile-container {
  margin-top: 3rem;
  background: linear-gradient(145deg, #2f3b53, #1f2738); /* Dark gradient */
  border-radius: 20px;
  padding: 3rem;
  box-shadow: 0 4px 30px rgba(0, 0, 0, 0.4);
}

/* Add a hint of Maze Yellow for elements that need a pop */
h1, .error-message p {
  color: #c39e29; /* Maze Yellow */
}

/* Responsiveness for Mobile */
@media (max-width: 768px) {
  .profile-view {
    padding: 2rem;
  }

  input {
    font-size: 1rem;
    padding: 0.5rem;
  }

  .profile-container {
    padding: 2rem;
  }
}
</style>
