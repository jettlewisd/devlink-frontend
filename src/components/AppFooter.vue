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
  background-color: var(--primary-color); /* Pure white background */
  color: var(--text-color); /* Dark grey text for readability */
  padding: 2rem 0;
  text-align: center;
  box-shadow: 0 -4px 15px var(--shadow-color); /* Subtle shadow */
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
  gap: 2rem;
}

.footer-nav a {
  text-decoration: none;
  color: var(--link-color); /* Bright blue for links */
  font-size: 1.1rem;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  transition: color 0.3s ease, transform 0.3s ease;
}

.footer-nav a:hover {
  color: var(--hover-color); /* Lighter blue on hover */
  transform: scale(1.05); /* Slight scale on hover */
}

small {
  font-size: 0.875rem;
  color: var(--copyright-color); /* Darker grey for copyright */
}
</style>
