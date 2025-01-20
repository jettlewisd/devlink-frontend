<template>
    <div>
      <AppHeader />
      <main>
        <h1>Your Posts</h1>
        <UserPosts />
        <CreatePostForm />
      </main>
      <AppFooter />
    </div>
  </template>
  
  <script>
  import AppHeader from "@/components/AppHeader.vue";
  import AppFooter from "@/components/AppFooter.vue";
  
  export default {
    name: "PostsView",
    components: { AppHeader, AppFooter, },
  };
  </script>
  