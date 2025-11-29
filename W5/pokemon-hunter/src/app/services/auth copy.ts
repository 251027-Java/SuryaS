import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import {jwtDecode} from 'jwt-decode';

@Injectable({
  providedIn: 'root',
})
export class Auth {
  constructor(private router: Router) {}

  setToken(token: string) {
    localStorage.setItem('JWT_token', token);
  }

  getToken(): string | null {
    return localStorage.getItem('JWT_token');
  }

  isAuthenticated(): boolean {
 
    const token = this.getToken();
    if (!token) return false;

    try {
      const decoded: any = jwtDecode(token);
      return decoded.exp * 1000 > Date.now(); 
      
    } catch {
      return false;
    }
  }

  logout() {
    localStorage.removeItem('JWT_token');
    this.router.navigate(['/']);
  }
}
