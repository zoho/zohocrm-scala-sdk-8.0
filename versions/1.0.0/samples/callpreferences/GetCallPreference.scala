package samples.callpreferences

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.callpreferences.{APIException, CallPreferencesOperations, ResponseHandler, ResponseWrapper}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.{INDataCenter, USDataCenter}
import com.zoho.crm.api.util.APIResponse

object GetCallPreference {

  @throws[Exception]
  def getCallPreference(): Unit = {
    val callPreferencesOperations = new CallPreferencesOperations()
    val response : Option[APIResponse[ResponseHandler]]= callPreferencesOperations.getCallPreference()

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
              case responseWrapper: ResponseWrapper =>
                val callPreferences = responseWrapper.getCallPreferences
                callPreferences match {
                  case Some(callPreference) =>
                    println(s"CallPreferences ShowFromNumber: ${callPreference.getShowFromNumber}")
                    println(s"CallPreferences ShowToNumber: ${callPreference.getShowToNumber}")
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
                println("Unexpected response handler")
            }
          } else if (apiResponse.getStatusCode != 204) {
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

      getCallPreference()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }

}
