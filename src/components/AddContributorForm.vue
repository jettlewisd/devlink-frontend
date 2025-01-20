<template>
    <div class="add-contributor-form">
        <h3>Add Contributor</h3>

        <!-- User Selection -->
         <label for="user">Select User</label>
         <select id="user" v-model="selectedUser">
            <option disabled value="">Select a user</option>
            <option v-for="user in users" :key="user.id" value="user.id">
                {{ user.first_name }} {{ user.last_name }}
            </option>
         </select>

         <!-- Role input -->
        <label for="role">Role:</label>
        <input 
            type="text" 
            id="role"
            v-model="role"
            placeholder="Enter role(e.g., Developer)"
        />

        <!-- Submit Button -->
         <button @click="submitContributor" :disabled="!selectedUser || !role">Add Contributor</button>
    </div>
</template>


<script>
export default {
    name: "AddContributorForm",

    data() {
        return {
            selectedUser: "", // store's the selected user's id 
            role: "", // Stores the role of the contributor
        };
    },

    computed: {
        users() {
            return this.$store.getters["user/allUsers"]; // fetches all users from vuex 
        },
    },

    methods: {
        submitContributor() {
            if (!this.selectedUser || !this.role) {
                alert("Please select a user and enter a role.");
                return;
            }
            
            const contributorData = {
                userId: this.selectedUser,
                role: this.role,
            };

            // dispatch action to add the contributor to the project 
            this.$store.dispatch("project/addContributor", contributorData);

            // reset form after submission 
            this.selectedUser = "";
            this.role = "";
        },  
    },

    created() {
        // fetch all users if not already in the store 
        if (!this.users.length){
            this.$store.dispatch("user/fetchUsers");
        }
    },
};
</script>


<style scoped>
.add-contributor-form {
    max-width: 400px;
    margin: 20px auto;
    padding: 20px;
    border: 1px solid #ddd;
    border-radius: 8px;
    background-color: #fff;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.form-title {
    font-size: 1.5rem;
    margin-bottom: 20px;
    text-align: center;
    color: #333;
}

.form-group {
    margin-bottom: 15px;
}

.form-label {
    display: block;
    font-weight: bold;
    margin-bottom: 5px;
    color: #555;
}

.form-input {
    width: 100%;
    padding: 10px;
    font-size: 1rem;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

.form-input:focus {
    border-color: #007bff;
    outline: none;
    box-shadow: 0 0 3px rgba(0, 123, 255, 0.5);
}

.form-button {
    width: 100%;
    padding: 10px;
    font-size: 1rem;
    color: #fff;
    background-color: #007bff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s;
}

.form-button:disabled {
    background-color: #ccc;
    cursor: not-allowed;
}

.form-button:hover:not(:disabled) {
    background-color: #0056b3;
}
</style>