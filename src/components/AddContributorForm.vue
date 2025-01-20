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

}
</script>








<style>

</style>