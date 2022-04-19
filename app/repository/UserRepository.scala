package repository

import akka.stream.impl.Stages.DefaultAttributes.recover

import javax.inject.Inject
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.PostgresProfile
import slick.jdbc.PostgresProfile.api._
import dto.Tables._
import play.api.mvc.Results._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class UserRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)
    extends IUserRepository  with HasDatabaseConfigProvider[PostgresProfile] {
  def existUser(userToken: String): Future[Boolean] = {
    db.run(User.filter(_.token == userToken).length.result).map {
      case 0 => false
      case _ => true
    }
  }

  def createUser(userToken: String): Future[String] = {
    val query = User returning( User.map(user => (user.name))) += UserRow(userToken, null ,0, null, null, "ポケモントレーナー")
    db.run(query)
  }
}
