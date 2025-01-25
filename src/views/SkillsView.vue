<template>
    <div>

      <main>
        <h1>Manage Skills</h1>
        <SkillsList />
        <AddSkillForm />
      </main>
      
    </div>
  </template>
  
  <script>
  import AddSkillForm from "@/components/AddSkillForm.vue";
  import SkillsList from "@/components/SkillList.vue";
  
  export default {
    name: "SkillsView",
    components: { SkillsList, AddSkillForm },
  };
  </script>
  