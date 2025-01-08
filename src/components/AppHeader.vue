<template>
   <header class="app-header">
    <div class="container">
        <!-- Logo + "DevLink" -->
        <a href="/" class="logo">DevLink</a>

        <!-- Main Nav -->
         <nav class="header-nav">
            <ul class="header-nav-list">
                <li><a href="/">Home</a></li>
                <li><a href="/profile">Profile</a></li>
                <li><a href="/projects">Projects</a></li>
                <li><a href="/connections">Connections</a></li>
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
/* Basic Styling */
.app-header {
  background-color: #4CAF50;
  padding: 1rem;
  color: white;
}

.container {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

/* Logo Styling */
.logo {
  font-size: 1.5rem;
  font-weight: bold;
  text-decoration: none;
  color: white;
}

/* Navigation Styling */
.navbar .nav-list {
  list-style: none;
  display: flex;
  gap: 1.5rem;
  margin: 0;
  padding: 0;
}

.navbar .nav-list a {
  text-decoration: none;
  color: white;
  font-size: 1rem;
  transition: color 0.3s;
}

.navbar .nav-list a:hover {
  color: #d4f1d4;
}

/* User Actions */
.user-actions a {
  text-decoration: none;
  color: white;
  font-size: 1rem;
}
</style>
  