package controllers

import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import usecase.UserUseCase

import javax.inject.{Inject, Singleton}
import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class UserController @Inject()(cc: ControllerComponents, uc: UserUseCase) extends AbstractController(cc) {
    def findUser(userToken: String): Action[AnyContent] = Action.async {
      uc.login(userToken).map(
        Ok(_)
      ).recover {
        case exception: Exception => InternalServerError(exception.getMessage)
      }
    }
}
