<template>
    <div class="project-card">

        <!-- Project Title -->
         <h3 class="project-title">{{ project.name }}</h3>

         <!-- Project Description-->
         <p class="project-description">{{ project.description }}</p>

         <!-- Project Dates -->
         <div class="project-dates">
            <p>Start Date: {{ formatDate(project.startDate) }}</p>
            <p>End Date: {{ project.endDate ? formatDate(project.endDate) : 'Ongoing' }}</p>
         </div>

         <!-- View Details Button -->
          <button @click="viewDetails" class="view-details-btn">View Details</button>
          
    </div>
</template>