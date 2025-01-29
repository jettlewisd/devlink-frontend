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
        required: false, // Optional to handle cases where data is not yet available
      },
    },
  };
  </script>
  
  <style scoped>
  /* Importing Poppins font */
  @import url("https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap");
  
  .user-profile-info {
    background: linear-gradient(145deg, #2f3b53, #1f2738); /* Dark blue-grey gradient */
    padding: 1.5rem;
    border-radius: 12px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
    color: #e0e0e0;
    font-family: "Poppins", sans-serif;
    max-width: 400px;
    margin: auto;
    text-align: center;
  }
  
  /* Section Title */
  .section-title {
    font-size: 1.8rem;
    font-weight: 600;
    color: #c39e29; /* Maze Yellow */
    margin-bottom: 1rem;
    letter-spacing: 1px;
  }
  
  /* User Name */
  .user-name {
    font-weight: 600;
    font-size: 1.4rem;
    color: #ffffff; /* White for emphasis */
    margin-bottom: 6px;
  }
  
  /* User Email */
  .user-email {
    font-size: 1.1rem;
    color: #b0b0b0; /* Soft grey */
  }
  </style>
  