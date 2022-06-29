package repository

import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.PostgresProfile
import slick.jdbc.PostgresProfile.api._
import dto.Tables._

import javax.inject.Inject
import scala.concurrent.Future

class PokemonRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)
  extends TPokemonRepository with HasDatabaseConfigProvider[PostgresProfile] {
  def getPokemonAbility(pokemonId: Int): Future[Seq[(Int, String)]] = {
    db.run(PokemonAbility.join(PokemonAbilityMaster).filter(_._1.pokemonId === pokemonId).map(ability =>
      (ability._1.ability, ability._2.name)).result
    )
  }

  def findPokemonBaseValue(pokemonId: Int): Future[PokemonBaseRow] = {
    db.run(PokemonBase.filter(_.id === pokemonId).result.head)
  }

  def findPokemonType(id: Int): Future[Seq[String]] = {
    db.run(PokemonType.join(PokemonTypeMaster).filter(_._1.pokemonId === id).map(
      pokemonType => pokemonType._2.name
    ).result)
  }

  def getPokemon(pokemonId: Int): Future[PokemonRow] = {
    db.run(Pokemon.filter(_.pokemonId === pokemonId).result.head)
  }

  def findPokemonName(input: String): Future[Seq[(Int, String)]] = {
    val query = Pokemon.filter(row => row.name like "%"+input+"%").map( row =>
      (row.pokemonId, row.name)
    ).result
    db.run(query)
  }
}
