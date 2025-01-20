<template>
    <div>
      <AppHeader />
      <main>
        <h1>Login</h1>
        <LoginForm />
      </main>
      <AppFooter />
    </div>
  </template>
  
  <script>
  import AppHeader from "@/components/AppHeader.vue";
  import AppFooter from "@/components/AppFooter.vue";
  
  export default {
    name: "LoginView",
    components: { AppHeader, AppFooter, },
  };
  </script>
  