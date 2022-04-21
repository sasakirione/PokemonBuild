package controllers

import play.api.mvc.{AbstractController, ControllerComponents}
import usecase.UserUseCase

import javax.inject.{Inject, Singleton}

@Singleton
class BuildingController @Inject()(cc: ControllerComponents, userUseCase: UserUseCase) extends AbstractController(cc) {

}
