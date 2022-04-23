package usecase

import port.FirebaseAuth
import repository.UserRepository

import javax.inject.Inject
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class UserUseCase @Inject()(private val userRepository: UserRepository, private val firebaseAuth: FirebaseAuth) {
  def login(userToken: String): Future[String] = {
    val uid = firebaseAuth.checkToken(userToken)
    userRepository.existUser(uid).flatMap {
      case true => userRepository.findUser(uid)
      case false => userRepository.createUser(uid)
    }
  }

  def changeName(userToken: String, newName: String): Future[Boolean] = {
    val uid = firebaseAuth.checkToken(userToken)
    userRepository.updateName(uid, newName).map {
      case 1 => true
      case _ => false
    }
  }
}
