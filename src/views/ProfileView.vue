<template>
    <div class="profile-view">
      
      <section class="profile-info">
        <UserProfileInfo />
        <UserSkills />
        <UserProjects />
      </section>
  
    </div>
  </template>
  
  <script>
  
  export default {
    name: 'ProfileView',
    components: {
    },
  };
  </script>
  
  <style scoped>
  .profile-view {
    padding: 2rem;
  }
  .profile-info {
    display: flex;
    flex-direction: column;
    gap: 2rem;
  }
  </style>
  