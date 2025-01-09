<template>
    <div class="project-list">
        <h2>Projects</h2>
        <div class="project-card" v-for="project in projects"  :key="project.id">
            <h3>{{ project.name }}</h3>
            <p>{{ project.description }}</p>
            <router-link :to="'/projects/' + project.id">View Details</router-link>
        </div>
    </div>
</template>




<script>
</script>




<style>
</style>