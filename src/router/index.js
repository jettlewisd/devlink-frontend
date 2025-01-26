import { createRouter, createWebHistory } from 'vue-router';

import HomeView from '@/views/HomeView.vue';
import ProfileView from '@/views/ProfileView.vue';
import ProjectsView from '@/views/ProjectsView.vue';
// import ConnectionsView from '@/views/ConnectionsView.vue';
import SkillsView from '@/views/SkillsView.vue';
// import PostsView from '@/views/PostsView.vue';
import LoginView from '@/views/LoginView.vue';
import RegisterView from '@/views/RegisterView.vue';
import NotFoundView from '@/views/NotFoundView.vue'; 

const routes = [
  { path: '/', name: 'home', component: HomeView },
  { path: '/profile/:id', name: 'profile', component: ProfileView },
  { path: '/projects', name: 'projects', component: ProjectsView },
  // { path: '/connections', name: 'connections', component: ConnectionsView },
  { path: '/skills', name: 'skills', component: SkillsView },
  // { path: '/posts', name: 'posts', component: PostsView },
  { path: '/login', name: 'login', component: LoginView },
  { path: '/register', name: 'register', component: RegisterView },
  { path: '/:pathMatch(.*)*', name: 'not-found', component: NotFoundView },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;