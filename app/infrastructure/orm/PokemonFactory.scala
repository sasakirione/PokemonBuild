package infrastructure.orm

import repository.PokemonRepository

import javax.inject.Inject

class PokemonFactory @Inject()(private val pokemonRepository: PokemonRepository){

}
