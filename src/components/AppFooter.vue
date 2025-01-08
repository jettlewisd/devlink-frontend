<template>
  <footer class="app-footer">
    <div class="container">

      <small>&copy;2025 DevLink, All Rights Reserved</small>

      <nav class="footer-nav" aria-label="Footer Navigation">
        <ul>
          <li><a href="/terms">Terms of Service</a></li>
          <li><a href="/privacy">Privacy Policy</a></li>
          <li><a href="/contact">Contact</a></li>
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
    background-color: #333;
    color: #fff;
    padding: 1rem 0;
    text-align: center;
  }
  
  .container {
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 1rem;
  }
  
  .footer-nav ul {
    list-style: none;
    padding: 0;
    margin: 0;
    display: flex;
    gap: 1.5rem;
  }
  
  .footer-nav a {
    text-decoration: none;
    color: #ccc;
    font-size: 0.875rem;
    transition: color 0.3s;
  }
  
  .footer-nav a:hover {
    color: #fff;
  }
  
  small {
    font-size: 0.75rem;
    color: #aaa;
  }
  </style>