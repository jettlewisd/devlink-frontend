import api from '@/api'; // Import the Axios instance from api.js

const UserService = {
  // Fetch all users
  fetchAllUsers() {
    return api.get('/users'); // GET /users
  },

  // Fetch a specific user by ID
  fetchUserById(id) {
    return api.get(`/users/${id}`); // GET /users/{id}
  },

  // Create a new user
  createUser(user) {
    return api.post('/users', user); // POST /users
  },

  // Update an existing user
  updateUser(id, user) {
    return api.put(`/users/${id}`, user); // PUT /users/{id}
  },

  // Delete a user
  deleteUser(id) {
    return api.delete(`/users/${id}`); // DELETE /users/{id}
  },

  // Fetch users by a specific skill
  fetchUsersBySkill(skillName) {
    return api.get(`/users/skills/${skillName}`); // GET /users/skills/{skillName}
  },

  // Fetch connections for a user
  fetchConnectionsForUser(userId) {
    return api.get(`/users/${userId}/connections`); // GET /users/{userId}/connections
  },

  // Fetch recommended connections for a user
  getRecommendedConnectionsForUser(userId) {
    return api.get(`/users/${userId}/recommended-connections`); // GET /users/{userId}/recommended-connections
  },
};

export default UserService;
