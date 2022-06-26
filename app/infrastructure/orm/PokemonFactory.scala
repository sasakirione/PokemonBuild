package infrastructure.orm

import domain.entity.Pokemon
import domain.value.{PokemonBaseValue, PokemonType}
import dto.Tables
import repository.PokemonRepository

import javax.inject.Inject
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class PokemonFactory @Inject()(private val pokemonRepository: PokemonRepository){
  def getPokemonData(id: Int, form: Int): Future[Pokemon] = {
    val pokemon = pokemonRepository.getPokemon(id, form)
    pokemon.flatMap(pokemon =>
      makePokemonObject(id,form, pokemon)
    )
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

  private def makePokemonObject(id: Int, form: Int, pokemon: Tables.PokemonRow): Future[Pokemon] = {
    val pokemonType = getPokemonType(pokemon.pokemonId)
    val pokemonBaseValue = getPokemonBaseValue(pokemon.pokemonId)
    val pokemonAbilities = pokemonRepository.getPokemonAbility(pokemon.pokemonId)
    for {
      pokemonType <- pokemonType
      pokemonBaseValue <- pokemonBaseValue
      pokemonAbilities <- pokemonAbilities
    } yield {
      new Pokemon(
        pokemonNo = id,
        pokemonFormNo = form,
        name = pokemon.name,
        pokemonType = pokemonType,
        pokemonBaseValue = pokemonBaseValue,
        pokemonAbilities = pokemonAbilities
      )
    }
  }

}
