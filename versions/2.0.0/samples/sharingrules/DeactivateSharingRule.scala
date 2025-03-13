package samples.sharingrules

import java.lang.reflect.Field
import java.util

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.USDataCenter
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.sharingrules._
import com.zoho.crm.api.util.{APIResponse, Model}
import com.zoho.crm.api.Initializer

object DeactivateSharingRule {

  def deactivateSharingRule(id: Long, moduleAPIName: String): Unit = {
    val sharingRulesOperations = new SharingRulesOperations(Option(moduleAPIName))
    val response = sharingRulesOperations.deactivateSharingRule(id)

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          if (apiResponse.getStatusCode == 204) {
            println("No Content")
            return
          }
          if (apiResponse.isExpected) {
            val actionHandler = apiResponse.getObject
            actionHandler match {
              case actionWrapper: ActionWrapper =>
                actionWrapper.getSharingRules.foreach {
                  case successResponse: SuccessResponse =>
                    println(s"Status: ${successResponse.getStatus.getValue}")
                    println(s"Code: ${successResponse.getCode.getValue}")
                    println("Details: ")
                    successResponse.getDetails.foreach { details =>
                      details.foreach { case (key, value) =>
                        println(s"$key: $value")
                      }
                    }
                    println(s"Message: ${successResponse.getMessage.getValue}")
                  case exception: APIException =>
                    println(s"Status: ${exception.getStatus.getValue}")
                    println(s"Code: ${exception.getCode.getValue}")
                    println("Details: ")
                    exception.getDetails.foreach { details =>
                      details.foreach { case (key, value) =>
                        println(s"$key: $value")
                      }
                    }
                    println(s"Message: ${exception.getMessage.getValue}")
                }
              case exception: APIException =>
                println(s"Status: ${exception.getStatus.getValue}")
                println(s"Code: ${exception.getCode.getValue}")
                println("Details: ")
                exception.getDetails.foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"$key: $value")
                  }
                }
                println(s"Message: ${exception.getMessage.getValue}")
            }
          } else {
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
      val id = 34771001L
      deactivateSharingRule(id, moduleAPIName)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
