package usecase

import repository.TUserRepository

import javax.inject.Inject
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class UserUseCase @Inject()(protected val userRepository: TUserRepository){
  def login(userToken: String): Future[String] =
    userRepository.existUser(userToken).flatMap {
      case true => userRepository.findUser(userToken)
      case false => userRepository.createUser(userToken)
    }

  def changeName(userToken: String, newName: String): Future[Boolean] =
    userRepository.updateName(userToken, newName).map {
      case 1 => true
      case _ => false
    }
}
