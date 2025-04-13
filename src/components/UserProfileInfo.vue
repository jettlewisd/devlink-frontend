<template>
  <div v-if="selectedUser" class="user-profile-info">
    <h3 class="section-title">User Info:</h3>
    <p class="user-name">
      {{ selectedUser.firstName }} {{ selectedUser.lastName }}
    </p>
    <p class="user-email">Email: {{ selectedUser.email }}</p>
  </div>
</template>

<script>
export default {
  name: "UserProfileInfo",
  props: {
    selectedUser: {
      type: Object,
      required: false,
    },
  },
};
</script>

<style scoped>
.user-profile-info {
  padding: 1.5rem;
  border-radius: 12px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
  color: var(--text-color);
  font-family: "Poppins", sans-serif;
  max-width: 400px;
  margin: auto;
  text-align: center;
  background: var(--secondary-bg-color);
}

.section-title {
  font-size: 1.8rem;
  font-weight: 600;
  color: var(--heading-color);
  margin-bottom: 1rem;
  letter-spacing: 1px;
}

.user-name {
  font-weight: 600;
  font-size: 1.4rem;
  color: var(--text-color);
  margin-bottom: 6px;
}

.user-email {
  font-size: 1.1rem;
  color: #b0b0b0;
}
</style>
