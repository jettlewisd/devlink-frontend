import { createStore } from 'vuex';
import project from './modules/project';  // import project module 

export default createStore({
    modules: {
        project,  // register the project module 
    },
});