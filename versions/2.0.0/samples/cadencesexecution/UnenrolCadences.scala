package samples.cadencesexecution

import java.lang.reflect.Field
import java.util.{ArrayList, List, Map}
import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.cadencesexecution.{APIException, ActionHandler, ActionWrapper, BodyWrapper, CadencesExecutionOperations, SuccessResponse}
import com.zoho.crm.api.dc.USDataCenter
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.Model

import scala.collection.mutable.ArrayBuffer

object UnenrolCadences {

  def unenrolCadences(moduleAPIName: String): Unit = {
    val cadencesExecutionOperations = new CadencesExecutionOperations()
    val request = new BodyWrapper()

    val cadencesIds: ArrayBuffer[String] = new ArrayBuffer[String]()
    cadencesIds.addOne("34770785001")
    request.setCadencesIds(cadencesIds)

    val ids: ArrayBuffer[String] = new ArrayBuffer[String]()
    ids.addOne("347750001")
    request.setIds(ids)

    val response: Option[APIResponse[ActionHandler]] = cadencesExecutionOperations.unenrollCadences(moduleAPIName, request)

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.isExpected) {
            apiResponse.getObject match {
              case actionWrapper: ActionWrapper =>
                val actionResponses = actionWrapper.getData
                for (actionResponse <- actionResponses) {
                  actionResponse match {
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
            }
          } else {
            val responseObject = apiResponse.getModel
            val fields = responseObject.getClass.getDeclaredFields
            for (field <- fields) {
              field.setAccessible(true)
              println(s"${field.getName}: ${field.get(responseObject)}")
            }
          }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    try {
      val environment: Environment = USDataCenter.PRODUCTION
      val token: Token = new OAuthToken.Builder()
        .clientID("Client_Id")
        .clientSecret("Client_Secret")
        .refreshToken("Refresh_Token")
        .build()

      new Initializer.Builder()
        .environment(environment)
        .token(token)
        .initialize()

      val moduleAPIName = "Leads"
      unenrolCadences(moduleAPIName)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
