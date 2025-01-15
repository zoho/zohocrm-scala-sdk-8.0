package samples.apis

import com.zoho.api.authenticator.OAuthToken
import com.zoho.api.authenticator.Token
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.apis.{APIException, APIsOperations, OperationTypes, ResponseHandler, ResponseWrapper, SupportedAPI}
import com.zoho.crm.api.dc.USDataCenter
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.Model
import com.zoho.crm.api.dc.DataCenter.Environment


object GetSupportedAPI {

  @throws[Exception]
  def getSupportedAPI(): Unit = {
    val filters: Option[String] = Option(null)
    val apisOperations = new APIsOperations(filters)
    val response: Option[APIResponse[ResponseHandler]] = apisOperations.getSupportedAPI()

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          if (apiResponse.getStatusCode == 204) {
            println("No Content")
            return
          }
          if (apiResponse.isExpected) {
            val responseHandler: ResponseHandler = apiResponse.getObject
            responseHandler match {
              case responseWrapper: ResponseWrapper =>
                val apis: List[SupportedAPI] = responseWrapper.getApis.toList
                if (apis != null) {
                  apis.foreach { api =>
                    println(s"API Path: ${api.getPath}")
                    val operationTypes: List[OperationTypes] = api.getOperationTypes.toList
                    operationTypes.foreach { operationType =>
                      println(s"API Operation Method: ${operationType.getMethod}")
                      println(s"API Operation OAuthScope: ${operationType.getOauthScope}")
                      println(s"API Operation MaxCredits: ${operationType.getMaxCredits}")
                      println(s"API Operation MinCredits: ${operationType.getMinCredits}")
                    }
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
          } else if (apiResponse.getStatusCode != 204) {
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

      getSupportedAPI()
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }
}