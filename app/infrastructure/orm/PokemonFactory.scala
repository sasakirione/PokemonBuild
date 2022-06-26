package infrastructure.orm

import domain.entity.Pokemon
import domain.value.{PokemonBaseValue, PokemonType}
import dto.Tables
import repository.PokemonRepository

import javax.inject.Inject
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class PokemonFactory @Inject()(private val pokemonRepository: PokemonRepository){
  def getPokemonData(pokemonId: Int): Future[Pokemon] = {
    val pokemonType = getPokemonType(pokemonId)
    val pokemonBaseValue = getPokemonBaseValue(pokemonId)
    val pokemonAbilities = pokemonRepository.getPokemonAbility(pokemonId)
    val pokemon = pokemonRepository.getPokemon(pokemonId)
    for {
      pokemonType <- pokemonType
      pokemonBaseValue <- pokemonBaseValue
      pokemonAbilities <- pokemonAbilities
      pokemon <- pokemon
    } yield {
      new Pokemon(
        pokemonNo = pokemon.id,
        pokemonFormNo = pokemon.form,
        name = pokemon.name,
        pokemonType = pokemonType,
        pokemonBaseValue = pokemonBaseValue,
        pokemonAbilities = pokemonAbilities
      )
    }
  }

  private def getPokemonType(pokemonId: Int): Future[PokemonType] = {
    val pokemonType = pokemonRepository.findPokemonType(pokemonId)
    pokemonType.map(pokemonType => new PokemonType(pokemonType))
  }

  private def getPokemonBaseValue(pokemonId: Int): Future[PokemonBaseValue] = {
    val pokemonBaseValue = pokemonRepository.findPokemonBaseValue(pokemonId)
    pokemonBaseValue.map(
      pokemonBaseValue => new PokemonBaseValue(
        hp = pokemonBaseValue.h,
        attack = pokemonBaseValue.a,
        defense = pokemonBaseValue.b,
        spAttack = pokemonBaseValue.c,
        spDefense = pokemonBaseValue.d,
        speed = pokemonBaseValue.s
      )
    )
  }

}
