import api from '@/api'; // Import the Axios instance from api.js

const ProjectsService = {
  // Fetch all projects
  fetchAllProjects() {
    return api.get('/projects'); // GET /projects
  },

  // Fetch a specific project by ID
  fetchProjectById(id) {
    return api.get(`/projects/${id}`); // GET /projects/{id}
  },

  // Create a new project
  createProject(project) {
    return api.post('/projects', project); // POST /projects
  },

  // Update an existing project
  updateProject(id, project) {
    return api.put(`/projects/${id}`, project); // PUT /projects/{id}
  },

  // Delete a project
  deleteProject(id) {
    return api.delete(`/projects/${id}`); // DELETE /projects/{id}
  },

  // Fetch projects created by a specific user
  fetchProjectsByCreator(createdBy) {
    return api.get(`/projects/createdBy/${createdBy}`); // GET /projects/{createdy}
  },
};

export default ProjectsService;
