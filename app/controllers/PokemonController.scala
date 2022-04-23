package controllers

import play.api.libs.json.{JsObject, JsValue, Json}
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import usecase.{PokemonUseCase, UserUseCase}

import javax.inject.Inject
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class PokemonController @Inject()(cc: ControllerComponents, pokemonUseCase: PokemonUseCase) extends AbstractController(cc){
  def getPokemonList(input: String): Action[AnyContent] = Action.async {
    pokemonUseCase.getPokemonCandidateList(input).map(pokemon =>
      Ok(pokemon)
    )
  }

  def getPokemon(no: Int) = play.mvc.Results.TODO
}
