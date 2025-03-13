package samples.duplicatecheckpreferences

import java.lang.reflect.Field
import java.util.Map
import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.dc.{INDataCenter, USDataCenter}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.duplicatecheckpreference.{ActionHandler, BodyWrapper, CurrentField, DuplicateCheckPreference, DuplicateCheckPreferenceOperations, FieldMappings, MappedField, MappedModule, TypeConfiguration, ActionWrapper, SuccessResponse, APIException}
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.Model

object DeleteDuplicateCheckPreference {

  def deleteDuplicateCheckPreference(moduleAPIName: String): Unit = {
    val duplicateCheckPreferenceOperations = new DuplicateCheckPreferenceOperations(Option(moduleAPIName))
    val response: Option[APIResponse[ActionHandler]] = duplicateCheckPreferenceOperations.deleteDuplicateCheckPreference()

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          if (apiResponse.isExpected) {
            apiResponse.getObject match {
              case actionWrapper: ActionWrapper =>
                val actionResponse = actionWrapper.getDuplicateCheckPreference
                actionResponse match {
                  case Some(actioResponse_1) =>
                    actioResponse_1 match {
                      case successResponse: SuccessResponse =>
                        println(s"Status: ${successResponse.getStatus.getValue}")
                        println(s"Code: ${successResponse.getCode.getValue}")
                        println("Details: ")
                        successResponse.getDetails.foreach { details =>
                          details.foreach { case (key, value) =>
                            println(s"$key: $value")
                          }
                        }
                        println(s"Message: ${successResponse.getMessage}")
                      case exception: APIException =>
                        println(s"Status: ${exception.getStatus.getValue}")
                        println(s"Code: ${exception.getCode.getValue}")
                        println("Details: ")
                        exception.getDetails.foreach { details =>
                          details.foreach { case (key, value) =>
                            println(s"$key: $value")
                          }
                        }
                        println(s"Message: ${exception.getMessage}")
                    }
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
                println(s"Message: ${exception.getMessage}")
              case _ =>
                val responseObject: Any = apiResponse.getModel
                val fields = responseObject.getClass.getDeclaredFields
                fields.foreach { field =>
                  field.setAccessible(true)
                  println(s"${field.getName}: ${field.get(responseObject)}")
                }
            }
          } else {
            val responseObject: Any = apiResponse.getModel
            val fields = responseObject.getClass.getDeclaredFields
            fields.foreach { field =>
              field.setAccessible(true)
              println(s"${field.getName}: ${field.get(responseObject)}")
            }
          }
      }
    }
  }

  @throws[Exception]
  def main(args: Array[String]): Unit = {
    try {
      val environment: Environment = USDataCenter.PRODUCTION
      val token: Token = new OAuthToken.Builder()
        .clientID("client_id")
        .clientSecret("client_secret")
        .grantToken("grant_token")
        .build()
      new Initializer.Builder()
        .environment(environment)
        .token(token)
        .initialize()

      val moduleAPIName = "Leads"
      deleteDuplicateCheckPreference(moduleAPIName)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}