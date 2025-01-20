<template>
  <div id="app">
    <!-- Optional Header -->
    <AppHeader />
    
    <!-- Main Content: Routed Views -->
    <router-view />

    <!-- Optional Footer -->
    <AppFooter />
  </div>
</template>

<script>
import AppHeader from '@/components/AppHeader.vue';
import AppFooter from '@/components/AppFooter.vue';

export default {
  name: 'App',
  components: {
    AppHeader,
    AppFooter,
  },
};
</script>

<style>
/* You can add global styles here if needed */
</style>
