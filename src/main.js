import { createApp } from 'vue';            // Import the Vue createApp function
import App from './App.vue';                // Import the root App component
import router from './router';              // Import the router from the 'router' folder
import store from './store'

// Create the Vue app instance
const app = createApp(App);

// Tell the app to use the router for navigation
app.use(router);

// Initialize Vuex store
app.use(store);

// Mount the Vue app to the DOM
app.mount('#app');
