# devlink-frontend



# DevLink - Frontend

DevLink is a web application that facilitates project collaboration. This frontend portion is built with Vue.js, Vuex for state management, and Axios for API calls. It provides users with the ability to interact with projects, contribute to them, and manage their skills, connections, and posts.

## Table of Contents

- [Overview](#overview)
- [Entities](#entities)
- [Components](#components)
- [Views](#views)
- [State Management (Vuex)](#state-management-vuex)
- [API Integration](#api-integration)
- [Project Setup](#project-setup)
- [Folder Structure](#folder-structure)

## Overview

DevLink allows users to create projects, view existing projects, and interact with project details. It communicates with a backend API using Axios, while Vuex manages the application's state.

## Entities

These are the main entities in the application:

1. **Project**
   - `id` (integer)
   - `name` (string)
   - `description` (string)
   - `startDate` (date)
   - `endDate` (date)
   - `createdBy` (integer)

2. **User**
   - `id` (integer)
   - `firstName` (string)
   - `lastName` (string)
   - `email` (string)
   - `password` (string)

3. **Post**
   - `id` (integer)
   - `userId` (integer)
   - `content` (text)
   - `createdAt` (timestamp)

4. **Skill**
   - `id` (integer)
   - `userId` (integer)
   - `skillName` (string)
   - `proficiencyLevel` (string)

5. **Connection**
   - `userId` (integer)
   - `connectedUserId` (integer)
   - `connectionDate` (timestamp)

6. **Project Contributor**
   - `projectId` (integer)
   - `userId` (integer)
   - `role` (string)
   - `dateJoined` (date)

## Components

The frontend consists of reusable components that display information and interact with the state. Below are the main components:

1. **ProjectCard.vue**
   - Displays details of a single project (name, description, dates).
   
2. **ProjectList.vue**
   - Displays a list of all projects using `ProjectCard` components.

3. **CreateProjectForm.vue**
   - A form to create a new project with fields for project details.

4. **ProjectDetails.vue**
   - Displays detailed information about a specific project.

5. **Navigation.vue**
   - A navigation bar for routing between views.

## Views

The views are responsible for displaying entire pages. Each view typically corresponds to a specific route in the app.

1. **HomeView.vue**
   - The main page displaying a list of projects.

2. **ProjectView.vue**
   - Displays detailed information about a selected project.

3. **CreateProjectView.vue**
   - A page with the form to create a new project.

## State Management (Vuex)

Vuex is used for managing the application's state. The main state includes:

1. **projects**: List of all projects.
2. **currentUser**: Information about the logged-in user (if applicable).

Vuex has the following actions and mutations:

- **Actions**:
  - `fetchProjects`: Fetches the list of projects.
  - `createProject`: Sends a request to create a new project.
  - `fetchProjectById`: Fetches details for a specific project.

- **Mutations**:
  - `setProjects`: Updates the list of projects.
  - `setCurrentUser`: Sets the current user in the state (optional if authentication is used).

## API Integration

The frontend communicates with the backend using Axios to perform CRUD operations for projects and other entities.

### Example API Calls

- `GET /projects`: Fetches all projects.
- `POST /projects`: Creates a new project.
- `GET /projects/{id}`: Fetches details of a specific project.

API calls are structured in separate service files located in the `src/services` folder, such as `projectService.js`.

Example of a service file (`src/services/projectService.js`):

```javascript
import axios from 'axios';

const API_URL = 'http://localhost:8081/api'; // Replace with your backend URL

export default {
  getProjects() {
    return axios.get(`${API_URL}/projects`);
  },

  createProject(project) {
    return axios.post(`${API_URL}/projects`, project);
  },

  getProjectById(projectId) {
    return axios.get(`${API_URL}/projects/${projectId}`);
  },
};









## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Lints and fixes files
```
npm run lint
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).
