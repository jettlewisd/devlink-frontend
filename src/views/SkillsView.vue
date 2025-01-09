<template>
    <div>
      <AppHeader />

      <main>
        <h1>Manage Skills</h1>
        <SkillsList />
        <AddSkillForm />
      </main>
      
      <AppFooter />
    </div>
  </template>
  
  <script>
  import AppHeader from "@/components/AppHeader.vue";
  import AppFooter from "@/components/AppFooter.vue";
  import SkillsList from "@/components/SkillsList.vue";
  import AddSkillForm from "@/components/AddSkillForm.vue";
  
  export default {
    name: "SkillsView",
    components: { AppHeader, AppFooter, SkillsList, AddSkillForm },
  };
  </script>
  