<template>
  <footer class="app-footer">
    <div class="container">

      <small>&copy;2025 DevLink, All Rights Reserved</small>

      <nav class="footer-nav" aria-label="Footer Navigation">
        <ul>
          <li><router-link to="/terms">Terms of Service</router-link></li>
          <li><router-link to="/privacy">Privacy Policy</router-link></li>
          <li><router-link to="/contact">Contact</router-link></li>
        </ul>
      </nav>

    </div>
  </footer>
</template>

<script>
export default {
  name: 'AppFooter',
};
</script>

<style scoped>
.app-footer {
  background-color: #1e2a47; /* Matching footer background to header */
  color: #ecf0f1; /* Light text for contrast */
  padding: 2rem 0; /* More padding for a spacious look */
  text-align: center;
  box-shadow: 0 -4px 15px rgba(0, 0, 0, 0.1); /* Subtle shadow to add depth */
}

.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 1.5rem;
}

.footer-nav ul {
  list-style: none;
  padding: 0;
  margin: 0;
  display: flex;
  gap: 2rem; /* More space between items */
}

.footer-nav a {
  text-decoration: none;
  color: #bdc3c7; /* Lighter link color */
  font-size: 1.1rem; /* Slightly larger font size */
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; /* Consistent font */
  transition: color 0.3s ease, transform 0.3s ease; /* Smooth hover transition */
}

.footer-nav a:hover {
  color: #c39e29; /* Maze Yellow on hover */
  transform: scale(1.05); /* Slight scaling effect on hover */
}

small {
  font-size: 0.875rem;
  color: #7f8c8d; /* Lighter color for copyright */
}
</style>
