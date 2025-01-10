/**
 * Centralized Axios Configuration for API Calls
 *
 * This file creates and configures an Axios instance for use throughout the app.
 * It ensures that all API calls share the same base URL, timeout, and headers,
 * and also sets up request and response interceptors for added functionality.
 */

import axios from 'axios';

// Create an Axios instance with default settings
const api = axios.create({
  baseURL: 'http://localhost:8080', // Change to match your backend base URL
  timeout: 10000, // Timeout after 10 seconds
  headers: {
    'Content-Type': 'application/json', // Default header for JSON requests
  },
});

// Request Interceptor
api.interceptors.request.use(
  (config) => {
    // Add Authorization token if it exists in localStorage
    const token = localStorage.getItem('authToken');
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => {
    // Log request errors
    console.error('Request error:', error);
    return Promise.reject(error);
  }
);

// Response Interceptor
api.interceptors.response.use(
  (response) => {
    // Return the response data if the request was successful
    return response;
  },
  (error) => {
    // Log response errors globally
    console.error('Response error:', error);
    return Promise.reject(error);
  }
);

// Export the configured Axios instance
export default api;
