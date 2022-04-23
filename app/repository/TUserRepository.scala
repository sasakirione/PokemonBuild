package repository

import scala.concurrent.Future

trait TUserRepository {
  def existUser(uid: String): Future[Boolean]
  def createUser(uid: String): Future[String]
  def findUser(uid: String): Future[String]
  def updateName(uid: String, newName: String): Future[Int]
}
