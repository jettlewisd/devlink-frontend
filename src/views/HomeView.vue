<template>
    <div class="home-view">
        <AppHeader />

        <section class="main-content">
            <h1>Welcome to DevLink</h1>

            <!-- Placeholder for ProjectList -->
            <ProjectList />    

            <!-- Placeholder for UserList -->
            <UserList />

            <!-- Placeholder for SkillsSummary -->
             <SkillsSummary />
        </section>

        <AppFooter />
    </div>
</template>

<script>
import AppHeader from '../components/AppHeader.vue';
import AppFooter from '../components/AppFooter.vue';
import ProjectList from '../components/ProjectList';

export default {
    name: 'HomeView',
    comopnents: {
        AppHeader,
        AppFooter,
        ProjectList,
    },
};
</script>

<style scoped>
/* Add some basic styles for spacing, etc. */
.home-view {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.main-content {
  padding: 2rem;
}
</style>