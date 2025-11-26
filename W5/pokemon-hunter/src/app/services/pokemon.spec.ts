import { TestBed } from '@angular/core/testing';

import { pokemonService } from './pokemon.service';

describe('Pokemon', () => {
  let service: pokemonService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(pokemonService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
