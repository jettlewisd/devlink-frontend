<template>
    <div class="profile-view">
      <AppHeader />
      
      <section class="profile-info">
        <UserProfileInfo />
        <UserSkills />
        <UserProjects />
        <UserConnections />
        <UserPosts />
      </section>
  
      <AppFooter />
    </div>
  </template>
  
  <script>
  import AppHeader from '../components/AppHeader.vue';
  import AppFooter from '../components/AppFooter.vue';
  import UserProfileInfo from '../components/UserProfileInfo.vue';
  import UserSkills from '../components/UserSkills.vue';
  import UserProjects from '../components/UserProjects.vue';
  import UserConnections from '../components/UserConnections.vue';
  import UserPosts from '../components/UserPosts.vue';
  
  export default {
    name: 'ProfileView',
    components: {
      AppHeader,
      AppFooter,
      UserProfileInfo,
      UserSkills,
      UserProjects,
      UserConnections,
      UserPosts,
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
  