import { Routes } from '@angular/router';
import { Login } from './components/login/login';
import { Dashboard } from './components/dashboard/dashboard';
import { Catch } from './components/catch/catch';
import { authGuardGuard } from './guards/auth-guard-guard';

export const routes: Routes = [
  {
    path:"",
    component:Login
  },
  {
    path:"dashboard",
    component:Dashboard,
    canMatch: [authGuardGuard]
  },
    {
    path:"catch",
    component:Catch,
    canMatch: [authGuardGuard]
  },
  {
    path: '***',
    redirectTo: ''
  }

];