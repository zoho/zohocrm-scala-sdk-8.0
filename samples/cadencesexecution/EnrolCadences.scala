package samples.cadencesexecution

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.cadencesexecution.{APIException, ActionHandler, ActionWrapper, BodyWrapper, CadencesExecutionOperations, SuccessResponse}
import com.zoho.crm.api.dc.{INDataCenter, USDataCenter}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.Model

import scala.collection.mutable.ArrayBuffer

object EnrolCadences {

  @throws[Exception]
  private def enrolCadences(moduleAPIName: String): Unit = {
    val cadencesExecutionOperations = new CadencesExecutionOperations()
    val request = new BodyWrapper()

    val cadencesIds = ArrayBuffer("34770785001")
    request.setCadencesIds(cadencesIds)

    val ids = ArrayBuffer("34770650001")
    request.setIds(ids)

    val response: Option[APIResponse[ActionHandler]] = cadencesExecutionOperations.enrollCadences(moduleAPIName, request)

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          if (apiResponse.isExpected) {
            apiResponse.getObject match {
              case actionWrapper: ActionWrapper =>
                val actionResponses = actionWrapper.getData()
                for (actionResponse <- actionResponses) {
                  actionResponse match {
                    case successResponse: SuccessResponse =>
                      println(s"Status: ${successResponse.getStatus().getValue}")
                      println(s"Code: ${successResponse.getCode().getValue}")
                      println("Details: ")
                      successResponse.getDetails().foreach { details =>
                        details.foreach { case (key, value) =>
                          println(s"$key: $value")
                        }
                      }
                      println(s"Message: ${successResponse.getMessage()}")
                    case exception: APIException =>
                      println(s"Status: ${exception.getStatus().getValue}")
                      println(s"Code: ${exception.getCode().getValue}")
                      println("Details: ")
                      exception.getDetails().foreach { details =>
                        details.foreach { case (key, value) =>
                          println(s"$key: $value")
                        }
                      }
                      println(s"Message: ${exception.getMessage()}")
                  }
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
                println(s"Message: ${exception.getMessage()}")
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
      enrolCadences(moduleAPIName)
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }
}
