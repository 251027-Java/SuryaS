import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
//rxjs
import { Pokemon } from '../interfaces/pokemon';

@Injectable({
  providedIn: 'root',
})
export class pokemonService {
  
  caughtPokemon:Pokemon[] = []

  constructor(private http:HttpClient){

  }

 
  getPokemon():Observable<Pokemon>{
    const randomNum:number = Math.floor(Math.random() * 1025) + 1;

      // request --> PokeAPI --> Pokemon object
    return this.http.get(`https://pokeapi.co/api/v2/pokemon/${randomNum}`).pipe(
        map<any, Pokemon>(data => ({
          id:data.id,
          name:data.name,
          sprite:data.sprites.front_default
        }))
      )
   }
      
  

}

