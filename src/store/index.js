import { createStore } from 'vuex';

import project from './modules/project';  // import project module 
import user from './modules/user';
import projectContributor from './modules/projectContributor';
import skill from './modules/skill';
import connection from './modules/connection';
import post from './modules/post';


export default createStore({
    modules: {
        project,  // register the project module, etc:
        user, // "" etc
        projectContributor,
        skill,
        post,
        connection,
    },
});