import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class TranslatorService {
  /* Services hold variables / functions when we want multiple components to access. good for uglier logic,
  we could have hidden out translate() function here.
  */
  constructor(){}
  
  translationCounter:number = 0


}
