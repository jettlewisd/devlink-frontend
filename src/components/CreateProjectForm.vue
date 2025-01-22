<template>
    <div class="create-project-form">
        <h3>Create a New Project</h3>

        <!-- Project Name input -->
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
            placeholder="Enter project description"
        ></textarea>

        <!-- Start Date input -->    
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

        <!-- Created By input (User ID) -->
        <label for="createdBy">Your User ID:</label>
        <input 
            type="number"
            id="created-by"
            v-model.number="createdBy"
            placeholder="Enter your user ID"
        />

        <!-- Submit Button -->
        <button @click="submitProject" :disabled="!isFormValid">Create Project</button>
    </div>
</template>

<script>
export default {
    name: "CreateProjectForm",

    data() {
        return {
            projectName: "",
            projectDescription: "",
            startDate: "",
            endDate: "",
            createdBy: null, // Added createdBy field
        };
    },

    computed: {
    isFormValid() {
        return (
            this.projectName.trim() !== "" &&
            this.projectDescription.trim() !== "" &&
            this.createdBy
            );
        },
    },


    methods: {
        submitProject() {
            // Validate the form input
            if (
                this.projectName.trim() === "" ||
                this.projectDescription.trim() === "" ||
                !this.createdBy
            ) {
                alert("Please fill out all fields.");
                return;
            }

            // Create a new project object with the data
            const newProject = {
                name: this.projectName,
                description: this.projectDescription,
                startDate: this.startDate,
                endDate: this.endDate,
                createdBy: this.createdBy, // Include createdBy from the form
            };

            // Dispatch the action to Vuex to add the project
            this.$store.dispatch("project/createProject", newProject);

            // Reset form fields after submission
            this.projectName = "";
            this.projectDescription = "";
            this.startDate = "";
            this.endDate = "";
            this.createdBy = null;
        },
    },
};
</script>

<style scoped>
.create-project-form {
  background-color: #f9f9f9;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  max-width: 500px;
  margin: 0 auto;
}

.create-project-form h3 {
  font-size: 1.8rem;
  margin-bottom: 20px;
  color: #333;
}

.create-project-form label {
  display: block;
  font-size: 1rem;
  margin: 10px 0 4px;
  color: #555;
}

.create-project-form input,
.create-project-form textarea {
  width: 100%;
  padding: 10px;
  font-size: 1rem;
  border-radius: 4px;
  border: 1px solid #ddd;
  margin-bottom: 20px;
  box-sizing: border-box;
}

.create-project-form input:focus,
.create-project-form textarea:focus {
  border-color: #4CAF50;
  outline: none;
}

.create-project-form button {
  width: 100%;
  padding: 10px;
  background-color: #4CAF50;
  color: white;
  font-size: 1.2rem;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.create-project-form button:hover {
  background-color: #45a049;
}

.create-project-form button:disabled {
  background-color: #ccc;
  cursor: not-allowed;
}
</style>
