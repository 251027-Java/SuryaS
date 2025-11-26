import { ChangeDetectorRef, Component, signal, WritableSignal } from '@angular/core';
import { pokemonService } from '../../services/pokemon.service';
import { Pokemon } from '../../interfaces/pokemon';
import { CommonModule, TitleCasePipe } from '@angular/common';

@Component({
  selector: 'app-catch',
  imports: [TitleCasePipe, CommonModule],
  templateUrl: './catch.html',
  styleUrl: './catch.css',
})

export class Catch {
 
  // constructor - inject the service
  constructor(private pokemonService:pokemonService //, private cdr:ChangeDetectorRef){}
    ){}
  // Variable to hold pokemon from PokeAPI'
  pokemon: WritableSignal<Pokemon> = signal({id:0, name:"", sprite:""});

  id:number = this.pokemon().id;

  //pokemon:any={};

  ngOnInit(){
    this.getPokemon()
  }

  getPokemon(){
    // observable returned ==> subscribe to access its data (HTTP response)
    this.pokemonService.getPokemon().subscribe(data => {
      console.log(data)
      this.pokemon.set(data)
    })
    //this.cdr.detectChanges()
  }

    catchPokemon(){
      this.pokemonService.caughtPokemon.push(this.pokemon())

      let formattedName = this.pokemon().name.replace(/-/g, ' ')
       formattedName = formattedName.split(' ')
                               .map(word => word.charAt(0).toUpperCase() + word.slice(1))
                               .join(' ');

       alert("Caught " + formattedName);
      //alert("Caught "+this.pokemon().name.charAt(0).toUpperCase()+this.pokemon().name.substring(1));
      this.pokemon.set({id:0, name:"", sprite:""});
    }
}
