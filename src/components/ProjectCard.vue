<template>
  <div class="project-card">
    <!-- Project Title -->
    <h3 class="project-title">{{ project.name || "Untitled Project" }}</h3>

    <!-- View Details Button -->
    <button @click="toggleDetails" class="view-details-btn">
      {{ showDetails ? "Hide Details" : "View Details" }}
    </button>

    <!-- Project Details -->
    <div v-if="showDetails" class="project-details">
      <!-- Project Description -->
      <p class="project-description">{{ project.description || "No description available." }}</p>

      <!-- Project Dates -->
      <div class="project-dates">
        <p>Start Date: {{ formatDate(project.startDate) }}</p>
        <p>End Date: {{ project.endDate ? formatDate(project.endDate) : "Ongoing" }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ProjectCard",
  props: {
    project: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      showDetails: false, // Track whether the details are shown or not
    };
  },
  methods: {
    formatDate(date) {
      if (!date) return "N/A";
      return new Date(date).toLocaleDateString("en-US"); // Explicit locale for consistency
    },
    toggleDetails() {
      this.showDetails = !this.showDetails; // Toggle the visibility of the details
    },
  },
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap');

.project-card {
  background: linear-gradient(145deg, var(--secondary-bg-color), #1f2738);
  border-radius: 12px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
  padding: 20px;
  margin: 20px 0;
  font-family: 'Poppins', sans-serif;
  color: var(--heading-color);
  width: 100%;
  max-width: 600px;
  transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.project-card:hover {
  transform: scale(1.03);
  box-shadow: 0 6px 15px rgba(0, 0, 0, 0.4);
}

.project-title {
  font-size: 1.8rem;
  font-weight: 600;
  color: var(--nav-hover-color);
  text-transform: uppercase;
  margin-bottom: 12px;
  letter-spacing: 1px;
}

.project-description {
  font-size: 1.2rem;
  line-height: 1.5;
  margin-bottom: 12px;
  color: #d1d1d1;
}

.project-dates p {
  font-size: 1rem;
  margin: 6px 0;
  color: #b0b0b0;
}

.view-details-btn {
  background-color: white;
  color: var(--primary-bg-color);
  font-weight: 600;
  padding: 10px 16px;
  border: none;
  border-radius: 6px;
  cursor: pointer;
  transition: background 0.3s ease;
  font-size: 1rem;
  margin-top: 10px;
}

.view-details-btn:hover {
  background-color: #e4c23d;
  color: var(--primary-bg-color);
}

@media (max-width: 768px) {
  .project-card {
    padding: 16px;
    max-width: 100%;
  }

  .project-title {
    font-size: 1.5rem;
  }

  .project-description {
    font-size: 1rem;
  }

  .view-details-btn {
    font-size: 0.9rem;
    padding: 8px 14px;
  }
}
</style>
