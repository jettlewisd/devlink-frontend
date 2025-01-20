<template>
   <div class="project-card">
     <!-- Project Title -->
     <h3 class="project-title">{{ project.name || "Untitled Project" }}</h3>
 
     <!-- Project Description -->
     <p class="project-description">{{ project.description || "No description available." }}</p>
 
     <!-- Project Dates -->
     <div class="project-dates">
       <p>Start Date: {{ formatDate(project.startDate) }}</p>
       <p>End Date: {{ project.endDate ? formatDate(project.endDate) : "Ongoing" }}</p>
     </div>
 
     <!-- View Details Button -->
     <button @click="viewDetails" class="view-details-btn">View Details</button>
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
 
   methods: {
     formatDate(date) {
       if (!date) return "N/A";
       return new Date(date).toLocaleDateString("en-US"); // Explicit locale for consistency
     },
     viewDetails() {
       this.$emit("project-card:view-details", this.project.id);
     },
   },
 };
 </script>
 
 <style scoped>
 /* ---------------------
    Card Container Styling
    --------------------- */
 .project-card {
   border: 1px solid #ddd;
   border-radius: 8px;
   padding: 16px;
   margin: 16px 0;
   box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
   background-color: #fff;
 }
 
 /* ---------------------
    Project Title Styling
    --------------------- */
 .project-title {
   font-size: 1.5rem;
   margin-bottom: 8px;
   color: #333;
 }
 
 /* ---------------------------
    Project Description Styling
    --------------------------- */
 .project-description {
   font-size: 1rem;
   margin-bottom: 16px;
   color: #555;
 }
 
 /* -------------------------
    Project Dates Styling
    ------------------------- */
 .project-dates p {
   font-size: 0.9rem;
   margin: 4px 0;
   color: #777;
 }
 
 /* ---------------------------
    View Details Button Styling
    --------------------------- */
 .view-details-btn {
   background-color: #4CAF50;
   color: white;
   border: none;
   padding: 8px 16px;
   border-radius: 4px;
   cursor: pointer;
   transition: background-color 0.3s;
 }
 
 /* Hover state for the button */
 .view-details-btn:hover {
   background-color: #45a049;
 }
 </style>
 