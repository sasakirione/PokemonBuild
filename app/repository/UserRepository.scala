package repository

import javax.inject.Inject
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.PostgresProfile
import slick.jdbc.PostgresProfile.api._
import dto.Tables._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class UserRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)
    extends TUserRepository  with HasDatabaseConfigProvider[PostgresProfile] {

  def existUser(userToken: String): Future[Boolean] = {
    db.run(User.filter(_.token === userToken).length.result).map {
      case 0 => false
      case _ => true
    }
  }

  def createUser(userToken: String): Future[String] = {
    val query = User returning User.map(user => user.name) += UserRow(userToken, null ,0, null, null, "ポケモントレーナー")
    db.run(query)
  }

  def findUser(userToken: String): Future[String]  = {
    val query = User.filter(_.token === userToken).result.head
    db.run(query).map(_.name)
  }

  def updateName(userToken: String, newName: String): Future[Int] = {
    val query = User.filter(_.token === userToken).map(_.name).update(newName)
    db.run(query)
  }
}
