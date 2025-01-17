<template>
    <div class="project-list">

        <!-- Check if there are any projects; if none, display a message -->
        <h2 class="list-title">Projects</h2>
        <div v-if="projects.length === 0" class="no-projects">
            <p>No projects available.</p>
        </div>

         <!-- Render the ProjectCard component for each project in the projects array -->
        <div v-else>
            <div v-for="project in projects" :key="project.id" class="project-item">
                <!-- Pass each project object as a prop to ProjectCard -->
                 <ProjectCard
                 :project="project"
                 @view-details="handleViewDetails"
                 />
            </div>
        </div>
    </div>
</template>



<script>
import { mapState } from 'vuex'; // To map the Vuex store state to component data
import ProjectCard from "@/components/ProjectCard"; // Import the ProjectCard component

export default {

    name: 'ProjectList',

    components: {
        ProjectCard, // Register the ProjectCard component
    },

    computed: {
        // Map projects state from Vuex store to the component’s data
        ...mapState({
            projects: state => state.project.projects, // Assuming the projects are stored in state.project.projects
        })
    },

    methods: {
        handleViewDetails(projectId) {
            // Handle the event emitted by ProjectCard when the "View Details" button is clicked
            console.log("View details for project with ID:", projectId);
            // You can add routing logic here if you want to navigate to a project detail page view 
            this.$router.push({ name:'ProjectDetail', params: { id: projectId } });
        },
    },
    
};
</script>



<style scoped>
.project-list {
    padding: 20px;
}

.list-title {
    font-size: 2rem;
    margin-bottom: 20px;
}

.no-projects {
    text-align: center;
    font-size: 1.2rem;
    color: #555;
}

.project-item {
    margin-bottom: 20px;
}

/* Style for each ProjectCard component inside the list */
.project-card {
    display: flex;
    flex-direction: column;
    gap: 10px;
}
</style>