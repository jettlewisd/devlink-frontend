<template>
    <div>
      <AppHeader />
      <main>
        <h1>Register</h1>
        <RegisterForm />
      </main>
      <AppFooter />
    </div>
  </template>
  
  <script>
  import AppHeader from "@/components/AppHeader.vue";
  import AppFooter from "@/components/AppFooter.vue";
  import RegisterForm from "@/components/RegisterForm.vue";
  
  export default {
    name: "RegisterView",
    components: { AppHeader, AppFooter, RegisterForm },
  };
  </script>
  