<template>
    <div v-if="selectedUser" class="user-profile-info p-4 border rounded-2xl shadow-md bg-white">
        <h3 class="section-title">User Info:</h3>
        <p class="font-semibold text-lg">Name: {{ selectedUser.firstName }} {{ selectedUser.lastName }}</p>
      <p>Email: {{ selectedUser.email }}</p>
    </div>
  </template>
  
  <script>
  export default {
    name: "UserProfileInfo",
    props: {
      selectedUser: {
        type: Object,
        required: false, // Optional to handle cases where data is not yet available
      },
    },
  };
  </script>
  
  <style scoped>

.section-title {
    font-size: 1.5em;
    margin-bottom: 1rem;
    font-weight: bold;
}

.user-profile-info {
margin: 1rem 0;
}
</style>
  