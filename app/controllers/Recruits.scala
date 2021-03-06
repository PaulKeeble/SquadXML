package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import models.RecruitEvaluation

object Recruits extends Controller with Secured  {
  def index = isAdmin { implicit request =>
     val oneMonthTrainingDeficient = RecruitEvaluation.recruitsMissingTrainingOneMonth
     val twoMonthTrainingDeficient = RecruitEvaluation.recruitsMissingTrainingTwoMonths
     val recruitsMeetingPromotion = RecruitEvaluation.recruitsMeetingPromotion
     Ok(views.html.recruits.index(oneMonthTrainingDeficient,twoMonthTrainingDeficient,recruitsMeetingPromotion))
  }
}