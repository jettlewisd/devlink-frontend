<template>
    <div class="user-list">
      <h2>Users</h2>
  
      <!-- Check if there are users to display -->
      <div v-if="users.length > 0">
        <!-- Loop through each user and display their information -->
        <div 
          v-for="user in users" 
          :key="user.id" 
          class="user-item"
        >
          <p>{{ user.first_name }} {{ user.last_name }}</p>
          <p>{{ user.email }}</p>
        </div>
      </div>
  
      <!-- Show a message if there are no users -->
      <div v-else class="no-users">
        <p>No users to display.</p>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'UserList',
    props: {
      users: {
        type: Array,  // The prop expects an array of users
        required: true,  // It's mandatory for the parent to pass this prop
      },
    },
  };
  </script>
  
  <style scoped>
  /* -------------------------
     User List Container
     ------------------------- */
  .user-list {
    margin: 16px 0;
    padding: 16px;
    border: 1px solid #ddd;
    border-radius: 8px;
    background-color: #f9f9f9;
  }
  
  /* -------------------------
     Heading Styling
     ------------------------- */
  .user-list h2 {
    font-size: 1.8rem;
    color: #333;
    margin-bottom: 16px;
    text-align: center;
  }
  
  /* -------------------------
     No Users Message
     ------------------------- */
  .no-users {
    text-align: center;
    color: #777;
    font-size: 1rem;
    margin-top: 16px;
  }
  
  /* -------------------------
     Individual User Item Styling
     ------------------------- */
  .user-item {
    margin-bottom: 8px;
    color: #333;
    font-size: 1rem;
  }
  </style>
  