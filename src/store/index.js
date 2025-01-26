import { createStore } from 'vuex';

import project from './modules/project';  
import user from './modules/user';
// import projectContributor from './modules/projectContributor';       ** Under construction.
import skill from './modules/skill';
// import connection from './modules/connection';       ** Under construction.
// import post from './modules/post';                   ** Under construction.


export default createStore({
    modules: {
        project,  // register the project module, etc:
        user, // "" etc
        skill,
    },
});

