<template>
    <div>
      <AppHeader />
      <main>
        <h1>Page Not Found</h1>
        <NotFoundMessage />
      </main>
      <AppFooter />
    </div>
  </template>
  
  <script>
  import AppHeader from "@/components/AppHeader.vue";
  import AppFooter from "@/components/AppFooter.vue";
  import NotFoundMessage from "@/components/NotFoundMessage.vue";
  
  export default {
    name: "404View",
    components: { AppHeader, AppFooter, NotFoundMessage },
  };
  </script>
  