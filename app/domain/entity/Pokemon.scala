package domain.entity

import domain.value.{PokemonBaseValue, PokemonType}

class Pokemon(val pokemonNo: Int, val pokemonFormNo: Int, val name: String, val pokemonType: PokemonType, val pokemonBaseValue: PokemonBaseValue, val pokemonAbilities: Seq[String]) {

}
