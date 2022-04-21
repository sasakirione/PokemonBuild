package repository

import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.PostgresProfile
import slick.jdbc.PostgresProfile.api._
import dto.Tables._

import javax.inject.Inject
import scala.concurrent.Future

class PokemonRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)
  extends TPokemonRepository with HasDatabaseConfigProvider[PostgresProfile] {

  def findPokemonName(input: String): Future[Seq[(Int, String)]] = {
    val query = Pokemon.filter(row => row.name like "%"+input+"%").map( row =>
      (row.id, row.name)
    ).result
    db.run(query)
  }
}
