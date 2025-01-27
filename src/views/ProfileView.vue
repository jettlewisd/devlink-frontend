<template>
  <div>
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
.input-container {
  text-align: center;
  margin-top: 1rem;
}

input {
  padding: 0.5rem;
  font-size: 1rem;
  border: 1px solid #ddd;
  border-radius: 5px;
}

.profile-container {
  margin-top: 2rem;
}

.error-message {
  color: red;
  font-size: 1.2rem;
  text-align: center;
  margin-top: 1rem;
}
</style>
