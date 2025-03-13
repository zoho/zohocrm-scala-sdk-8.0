package samples.callpreferences

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.callpreferences.{APIException, ActionWrapper, BodyWrapper, CallPreferences, CallPreferencesOperations, SuccessResponse}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.{INDataCenter, USDataCenter}

object UpdateCallPreference {

  def updateCallPreference(): Unit = {
    val callPreferencesOperations = new CallPreferencesOperations()
    val bodyWrapper = new BodyWrapper()
    val callPreferences = new CallPreferences()

    callPreferences.setShowFromNumber(Option(true))
    callPreferences.setShowToNumber(Option(true))
    bodyWrapper.setCallPreferences(Option(callPreferences))

    val response = callPreferencesOperations.updateCallPreference(bodyWrapper)

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.isExpected) {
            apiResponse.getObject match {
              case actionWrapper: ActionWrapper =>
                val actionResponse = actionWrapper.getCallPreferences
                actionResponse match {
                  case Some(actionResponse1) =>
                    actionResponse1 match {
                      case successResponse: SuccessResponse =>
                        println(s"Status: ${successResponse.getStatus.getValue}")
                        println(s"Code: ${successResponse.getCode.getValue}")
                        successResponse.getDetails.foreach { details =>
                          details.foreach { case (key, value) =>
                            println(s"$key: $value")
                          }
                        }
                        println(s"Message: ${successResponse.getMessage}")

                      case exception: APIException =>
                        println(s"Status: ${exception.getStatus.getValue}")
                        println(s"Code: ${exception.getCode.getValue}")
                        exception.getDetails.foreach { details =>
                          details.foreach { case (key, value) =>
                            println(s"$key: $value")
                          }
                        }
                        println(s"Message: ${exception.getMessage}")

                      case _ =>
                        println("Unexpected ActionResponse type")
                    }
                }

              case exception: APIException =>
                println(s"Status: ${exception.getStatus.getValue}")
                println(s"Code: ${exception.getCode.getValue}")
                exception.getDetails.foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"$key: $value")
                  }
                }
                println(s"Message: ${exception.getMessage}")

              case _ =>
                println("Unexpected ActionHandler type")
            }
          } else {
            val responseObject = apiResponse.getModel
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

      updateCallPreference()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
