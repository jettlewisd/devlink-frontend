


# DevLink - Frontend

DevLink is a growing web application that facilitates project collaboration. This frontend portion is built with Vue.js, Vuex for state management, and Axios for API calls. It provides users with the ability to interact with projects, contribute to them, and manage their skills, connections, and posts.

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

DevLink is a platform for developers to showcase their skills, connect with others, and collaborate on projects.
Build your profile, list your expertise, and find like-minded professionals to grow your network.
 
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

4. **ProjectInfo.vue**
   - Displays detailed information about a specific project.


** Check the Components package to view all components.

## Views

The views are responsible for displaying entire pages. Each view typically corresponds to a specific route in the app.

1. **HomeView.vue**
   - The main page.

2. **ProjectsView.vue**
   - Displays detailed information about a selected project.

3. **ProfileView.vue**
   - A page to view the current user's profile.

** View the Views package to view all views!


## API Integration

The frontend communicates with the backend using Axios to perform CRUD operations for projects and other entities.

### Example API Calls

- `GET /projects`: Fetches all projects.
- `POST /projects`: Creates a new project.
- `GET /projects/{id}`: Fetches details of a specific project.

API calls are structured in separate service files located in the `src/services` folder, such as `ProjectService.js`.

Upcoming features for this project include testing and login capabilites to tailor the experience for the logged in user.


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

