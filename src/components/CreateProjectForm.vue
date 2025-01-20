<template>
    <div class="create-project-form">
        <h3>Create New Project</h3>

        <!-- Project Name Input -->
        <label for="projectName">Project Name:</label>
        <input 
            type="text"
            id="project-name"
            v-model="projectName"
            placeholder="Enter project name"
        />

        <!-- Project Description input -->
         <label for="projectDescription">Project Description:</label>
         <textarea 
            id="project-description"
            v-model="projectDescription"
            placeholder="Enter project description">
        </textarea>

        <!-- Start date input -->
         <label for="startDate">Start Date:</label>
         <input 
            type="date"
            id="start-date"
            v-model="startDate"
        />

        <!-- End Date input -->
         <label for="endDate">End Date:</label>
         <input 
            type="date"
            id="end-date"
            v-model="endDate"
        />

        <!-- submit button -->
         <button @click="submitProject">Create Project</button>
    </div>
</template>





<script>
export default {

    name: "CreateProjectForm",

};
</script>










<style>

</style>