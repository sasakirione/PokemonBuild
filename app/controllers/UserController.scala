package controllers

import play.api.mvc.{AbstractController, Action, ControllerComponents}

import javax.inject.{Inject, Singleton}

@Singleton
class UserController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
    /*def findUser(): Action[String] = Action.async(
      OK()
    )*/
}
