import { createApp } from 'vue';            // Import the Vue createApp function
import App from './App.vue';                // Import the root App component
import router from './router';              // Import the router from the 'router' folder

// Create the Vue app instance
const app = createApp(App);

// Tell the app to use the router for navigation
app.use(router);

// Mount the Vue app to the DOM
app.mount('#app');
