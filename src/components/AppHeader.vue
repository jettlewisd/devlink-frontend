<template>
  <header class="app-header">
    <div class="container">
      <!-- Logo + "DevLink" -->
      <a href="/" class="logo">DevLink</a>

      <!-- Main Nav -->
      <nav class="header-nav">
        <ul class="header-nav-list">
          <li><router-link to="/">Home</router-link></li>
          <li><router-link to="/profile">Profile</router-link></li>
          <li><router-link to="/projects">Projects</router-link></li>
          <li><router-link to="/skills">Skills</router-link></li>
          <li><router-link to="/login">Login</router-link></li>
        </ul>
      </nav>

      <!-- User Auth or Menu -->
      <div class="user-actions">
        <a href="/login">Login</a>
      </div>
    </div>
  </header>
</template>

<script>
export default {
  name: "AppHeader",
};
</script>

<style scoped>
/* Updated header with sleek, cohesive style */
.app-header {
  background-color: #1e2a47; /* New background color - Darker blue to contrast with body */
  padding: 1.5rem;
  color: white;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
}

.container {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

/* Logo Styling */
.logo {
  font-size: 1.75rem;
  font-weight: bold;
  text-decoration: none;
  color: #c39e29; /* Maze Yellow for logo */
  letter-spacing: 1px;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; /* Matching font */
  transition: color 0.3s;
}

.logo:hover {
  color: #f1e4b3; /* Lighter yellow on hover */
}

/* Navigation Styling */
.header-nav-list {
  list-style: none;
  display: flex;
  gap: 2rem;
  margin: 0;
  padding: 0;
}

.header-nav-list a {
  text-decoration: none;
  color: white;
  font-size: 1.1rem;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; /* Matching font */
  transition: color 0.3s, transform 0.3s;
}

.header-nav-list a:hover {
  color: #c39e29; /* Maze Yellow on hover */
  transform: scale(1.1); /* Slight scaling effect on hover */
}

/* User Actions */
.user-actions a {
  text-decoration: none;
  color: white;
  font-size: 1.1rem;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; /* Matching font */
  transition: color 0.3s;
}

.user-actions a:hover {
  color: #c39e29; /* Maze Yellow on hover */
}
</style>
