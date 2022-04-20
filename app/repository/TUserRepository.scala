package repository

import scala.concurrent.Future

trait TUserRepository {
  def existUser(userToken: String): Future[Boolean]
  def createUser(userToken: String): Future[String]
  def findUser(userToken: String): Future[String]
  def updateName(userToken: String, newName: String): Future[Int]
}
