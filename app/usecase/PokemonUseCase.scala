package usecase

import play.api.libs.json.{JsObject, Json}
import repository.{PokemonRepository, UserRepository}

import javax.inject.Inject
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class PokemonUseCase @Inject()(private val pokemonRepository: PokemonRepository) {
  def getPokemonCandidateList(input: String): Future[JsObject] =
    pokemonRepository.findPokemonName(input).map(pokemons => pokemons.map(pokemon =>
      Json.obj(
        "no" -> pokemon._1,
        "name" -> pokemon._2
      )
    )).map(pokemons =>
    Json.obj("pokemon" -> pokemons)
  )

}
