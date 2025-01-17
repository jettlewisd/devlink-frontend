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


<script>
export default {

    name: "ProjectCard", // the component's name

    props: {
        project: {
            type: Object, // the prop expects an object 
            required: true, // it's mandatory for the parent to pass this prop 
        },
    },

    methods: {

        formatDate(date) {
             // formats the date into a readable format:
             if (!date) return "N/A"; // Returns "N/A" if the date is null or undefined
             return new Date(date).toLocaleDateString(); // Converts the date to a local string
        },
        viewDetails() {
            // Emits a custom event named 'view-details' with the project's ID
            this.$emit("view-details", this.project.id);
         },
    },

};
</script>


<style scoped>
/* ---------------------
   Card Container Styling
   --------------------- */
.project-card {
  border: 1px solid #ddd; /* Adds a light border around the card */
  border-radius: 8px; /* Rounds the corners of the card */
  padding: 16px; /* Adds space inside the card for better readability */
  margin: 16px 0; /* Adds space above and below the card */
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* Creates a subtle shadow for a lifted effect */
  background-color: #fff; /* Sets the card background to white */
}

/* ---------------------
   Project Title Styling
   --------------------- */
.project-title {
  font-size: 1.5rem; /* Sets a large font size for prominence */
  margin-bottom: 8px; /* Adds spacing below the title */
  color: #333; /* Sets a dark gray color for good readability */
}

/* ---------------------------
   Project Description Styling
   --------------------------- */
.project-description {
  font-size: 1rem; /* Sets a standard font size for descriptions */
  margin-bottom: 16px; /* Adds spacing below the description */
  color: #555; /* Uses a medium gray for a softer contrast */
}

/* -------------------------
   Project Dates Styling
   ------------------------- */
.project-dates p {
  font-size: 0.9rem; /* Slightly smaller font for secondary information */
  margin: 4px 0; /* Adds minimal spacing between the lines */
  color: #777; /* Lighter gray to visually separate dates from other content */
}

/* ---------------------------
   View Details Button Styling
   --------------------------- */
.view-details-btn {
  background-color: #4CAF50; /* Sets a green background for the button */
  color: white; /* Makes the text color white for contrast */
  border: none; /* Removes any default border from the button */
  padding: 8px 16px; /* Adds inner padding for a clickable area */
  border-radius: 4px; /* Rounds the button's corners for a softer look */
  cursor: pointer; /* Changes the cursor to indicate a clickable element */
  transition: background-color 0.3s; /* Smooth transition effect on hover */
}

/* Hover state for the button */
.view-details-btn:hover {
  background-color: #45a049; /* Slightly darker green for hover feedback */
}
</style>
