import { Routes } from '@angular/router';
import { Dashboard } from './components/dashboard/dashboard';
import { Translate } from './components/translate/translate';

/*Only place where we define our routes. Remember routing is how we dynamically move components in and out of the view. */
export const routes: Routes = [
    {
        path:"", // empty url for path
        component: Dashboard
        
    },
    {
        path:"translate",
        component: Translate
    }
];
