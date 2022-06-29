package usecase

import infrastructure.orm.PokemonFactory
import play.api.libs.json.{JsObject, Json}
import repository.{PokemonRepository, UserRepository}

import javax.inject.Inject
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class PokemonUseCase @Inject()(private val pokemonRepository: PokemonRepository, private val pokemonFactory: PokemonFactory) {
  def getPokemonCandidateList(input: String): Future[JsObject] =
    pokemonRepository.findPokemonName(input).map(pokemons => pokemons.map(pokemon =>
      Json.obj(
        "no" -> pokemon._1,
        "name" -> pokemon._2
      )
    )).map(pokemons =>
    Json.obj("pokemon" -> pokemons)
  )

  def getPokemonData(pokemonId: Int): Future[JsObject] =
    pokemonFactory.getPokemonData(pokemonId).map(pokemon =>
      Json.obj(
        "id" -> pokemonId,
        "no" -> pokemon.pokemonNo,
        "form" -> pokemon.pokemonFormNo,
        "name" -> pokemon.name,
        "type" -> pokemon.pokemonType.typeNames,
        "ability" -> pokemon.pokemonAbilities,
        "pokemonBaseValue" -> List(
          pokemon.pokemonBaseValue.hp,
          pokemon.pokemonBaseValue.attack,
          pokemon.pokemonBaseValue.defense,
          pokemon.pokemonBaseValue.spAttack,
          pokemon.pokemonBaseValue.spDefense,
          pokemon.pokemonBaseValue.speed
        )
      )
    )
}
