import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})

export class Auth {
  private _isAuthenticated: boolean = false;
  public isAuthenticated(): boolean {
    return this._isAuthenticated;
  }

  public authenticateUser(): void{
    this._isAuthenticated = true;
  }
  // [x: string]: any;
  
  public logout(): void{
    this._isAuthenticated = false;
  }

}



