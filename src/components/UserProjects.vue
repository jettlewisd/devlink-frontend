<template>
  <div v-if="selectedUser">
    <h3 class="section-title">User Projects:</h3>
    
    <ul v-if="selectedProjects.length > 0" class="project-list">
      <li v-for="(project, index) in selectedProjects" :key="index" class="project-item">
        <div class="project-name">{{ project.name }}</div>
        <div class="project-description">{{ project.description }}</div>
        <div class="project-dates">
          <span class="start-date">Start: {{ formatDate(project.startDate) }}</span>
          <span v-if="project.endDate" class="end-date">End: {{ formatDate(project.endDate) }}</span>
        </div>
      </li>
    </ul>
    
    <p v-else class="no-projects">No projects available</p>
  </div>
</template>

<script>
export default {
  props: {
    selectedUser: Object,
  },

  computed: {
    selectedProjects() {
      return this.$store.state.project.selectedProjects || [];
    },
  },

  watch: {
    selectedUser(newVal, oldVal) {
      if (newVal && newVal.id && newVal !== oldVal) {
        this.fetchProjectsByCreator(newVal.id);
      }
    },
  },

  methods: {
    async fetchProjectsByCreator(createdBy) {
      try {
        console.log("Fetching projects for user ID:", createdBy);
        await this.$store.dispatch("project/fetchProjectsByCreator", createdBy);
      } catch (error) {
        console.error("Error fetching projects:", error);
      }
    },

    formatDate(date) {
      const options = { year: "numeric", month: "long", day: "numeric" };
      return new Date(date).toLocaleDateString(undefined, options);
    },
  },

  created() {
    if (this.selectedUser && this.selectedUser.id) {
      console.log("Fetching projects for user ID:", this.selectedUser.id);
      this.fetchProjectsByCreator(this.selectedUser.id);
    }
  },
};
</script>

<style scoped>
.section-title {
  font-size: 1.8rem;
  font-weight: 600;
  color: var(--heading-color);
  text-transform: uppercase;
  letter-spacing: 1px;
  margin-bottom: 1.2rem;
  font-family: "Poppins", sans-serif;
}

.project-list {
  list-style-type: none;
  padding: 0;
}

.project-item {
  background: var(--secondary-bg-color);
  border-radius: 12px;
  padding: 16px;
  margin-bottom: 12px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
  transition: transform 0.3s ease, box-shadow 0.3s ease;
  color: var(--text-color);
}

.project-item:hover {
  transform: scale(1.03);
  box-shadow: 0 6px 15px rgba(0, 0, 0, 0.4);
}

.project-name {
  font-weight: 600;
  font-size: 1.4rem;
  color: var(--heading-color);
  margin-bottom: 6px;
}

.project-description {
  font-size: 1.1rem;
  color: #d1d1d1;
  margin-bottom: 6px;
}

.project-dates {
  font-size: 1rem;
  color: #b0b0b0;
}

.start-date,
.end-date {
  font-weight: 500;
  margin-right: 10px;
}

.no-projects {
  font-style: italic;
  font-size: 1.1rem;
  color: #b0b0b0;
}
</style>
