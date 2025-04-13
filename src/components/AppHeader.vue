<template>
  <header class="app-header">
    <div class="container">
      <a href="/" class="logo">DevLink</a>

      <nav class="header-nav">
        <ul class="header-nav-list">
          <li><router-link to="/">Home</router-link></li>
          <li><router-link to="/profile">Profile</router-link></li>
          <li><router-link to="/projects">Projects</router-link></li>
          <li><router-link to="/skills">Skills</router-link></li>
        </ul>
      </nav>

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
.app-header {
  background-color: var(--secondary-bg-color);
  padding: 1.5rem;
  color: var(--text-color);
  box-shadow: 0 4px 15px var(--border-color);
}

.container {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.logo {
  font-size: 1.75rem;
  font-weight: bold;
  text-decoration: none;
  color: var(--heading-color);
  letter-spacing: 1px;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  transition: color 0.3s;
}

.logo:hover {
  color: var(--nav-hover-color);
}

.header-nav-list {
  list-style: none;
  display: flex;
  gap: 2rem;
  margin: 0;
  padding: 0;
}

.header-nav-list a {
  text-decoration: none;
  color: var(--heading-color);
  font-size: 1.1rem;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  transition: color 0.3s, transform 0.3s;
}

.header-nav-list a:hover {
  color: var(--nav-hover-color);
  transform: scale(1.1);
}

.user-actions a {
  text-decoration: none;
  color: var(--heading-color);
  font-size: 1.1rem;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  transition: color 0.3s;
}

.user-actions a:hover {
  color: var(--nav-hover-color);
}
</style>
