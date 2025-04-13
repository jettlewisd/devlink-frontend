<template>
  <div class="user-list">
    <h2>Users</h2>
    <div v-if="users.length > 0">
      <div v-for="user in users" :key="user.id" class="user-item">
        <p>{{ user.first_name }} {{ user.last_name }}</p>
        <p>{{ user.email }}</p>
      </div>
    </div>
    <div v-else class="no-users">
      <p>No users to display.</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'UserList',
  props: {
    users: {
      type: Array,
      required: true,
    },
  },
};
</script>

<style scoped>
.user-list {
  margin: 16px 0;
  padding: 16px;
  background-color: var(--secondary-bg-color);
  border-radius: 8px;
}

.user-list h2 {
  font-size: 1.8rem;
  color: var(--heading-color);
  margin-bottom: 16px;
  text-align: center;
}

.no-users {
  text-align: center;
  color: #777;
  font-size: 1rem;
  margin-top: 16px;
}

.user-item {
  margin-bottom: 8px;
  color: var(--text-color);
  font-size: 1rem;
}
</style>
