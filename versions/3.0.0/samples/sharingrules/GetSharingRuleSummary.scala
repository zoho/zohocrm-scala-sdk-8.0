package samples.sharingrules

import java.lang.reflect.Field
import java.util

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.USDataCenter
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.sharingrules._
import com.zoho.crm.api.util.{APIResponse, Model}
import com.zoho.crm.api.Initializer

object GetSharingRuleSummary {

  def getSharingRuleSummary(moduleAPIName: String): Unit = {
    val sharingRulesOperations = new SharingRulesOperations(Option(moduleAPIName))
    val response = sharingRulesOperations.getSharingRuleSummary()

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          if (apiResponse.getStatusCode == 204) {
            println("No Content")
            return
          }
          if (apiResponse.isExpected) {
            val responseHandler = apiResponse.getObject
            responseHandler match {
              case responseWrapper: SummaryResponseWrapper =>
                responseWrapper.getSharingRulesSummary().foreach { ruleSummary =>
                  val module = ruleSummary.getModule().get
                  if (module != null) {
                    println(s"RulesSummary Module APIName: ${module.getAPIName()}")
                    println(s"RulesSummary Module Id: ${module.getId()}")
                  }
                  println(s"RulesSummary RuleComputationStatus: ${ruleSummary.getRuleComputationStatus()}")
                  println(s"RulesSummary RuleCount: ${ruleSummary.getRuleCount()}")
                }
              case exception: APIException =>
                println(s"Status: ${exception.getStatus().getValue}")
                println(s"Code: ${exception.getCode().getValue}")
                println("Details: ")
                exception.getDetails().foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"$key: $value")
                  }
                }
                println(s"Message: ${exception.getMessage().getValue}")
            }
          } else if (apiResponse.getStatusCode != 204) {
            val responseObject = apiResponse.getModel
            val clas = responseObject.getClass
            val fields = clas.getDeclaredFields
            fields.foreach { field =>
              field.setAccessible(true)
              println(s"${field.getName}: ${field.get(responseObject)}")
            }
          }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    try {
      val environment = USDataCenter.PRODUCTION
      val token = new OAuthToken.Builder()
        .clientID("Client_Id")
        .clientSecret("Client_Secret")
        .refreshToken("Refresh_Token")
        .build()

      new Initializer.Builder().environment(environment).token(token).initialize()

      val moduleAPIName = "Leads"
      getSharingRuleSummary(moduleAPIName)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
