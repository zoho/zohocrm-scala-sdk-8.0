package samples.currencies

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.currencies.*
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse

object EnableBaseCurrency {

  @throws[Exception]
  private def enableBaseCurrency(): Unit = {
    val currenciesOperations = new CurrenciesOperations()
    val request = new BaseCurrencyWrapper()
    val baseCurrency = new BaseCurrency()
    baseCurrency.setPrefixSymbol(Option(true))
    baseCurrency.setName(Option("Algerian Dinar - DZD"));
    baseCurrency.setIsoCode(Option("AFN"))
    baseCurrency.setExchangeRate(Option("1.0"))
    request.setBaseCurrency(Option(baseCurrency))
    val response: Option[APIResponse[ActionHandler]] = currenciesOperations.enableBaseCurrency(request)
    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          if (apiResponse.isExpected) {
            val actionHandler = apiResponse.getObject
            actionHandler match {
              case baseCurrencyActionWrapper: BaseCurrencyActionWrapper =>
                val actionResponse = baseCurrencyActionWrapper.getBaseCurrency().get
                if(actionResponse != null) {
                  actionResponse match {
                    case successResponse: SuccessResponse =>
                      println("Status: " + successResponse.getStatus().getValue)
                      println("Code: " + successResponse.getCode().getValue)
                      println("Details: ")
                      successResponse.getDetails().foreach { details =>
                        details.foreach { case (key, value) =>
                          println(s"$key: $value")
                        }
                      }
                      println("Message: " + successResponse.getMessage().getValue)
                    case exception: APIException =>
                      println("Status: " + exception.getStatus().getValue)
                      println("Code: " + exception.getCode().getValue)
                      println("Details: ")
                      exception.getDetails().foreach { details =>
                        details.foreach { case (key, value) =>
                          println(s"$key: $value")
                        }
                      }
                      println("Message: " + exception.getMessage().getValue)
                  }
                }
              case exception: APIException =>
                println("Status: " + exception.getStatus().getValue)
                println("Code: " + exception.getCode().getValue)
                println("Details: ")
                exception.getDetails().foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"$key: $value")
                  }
                }
                println("Message: " + exception.getMessage().getValue)
              case _ =>
            }
          } else {
            val responseObject = apiResponse.getModel
            val fields = responseObject.getClass.getDeclaredFields
            fields.foreach { field =>
              field.setAccessible(true)
              println(s"${field.getName}: ${field.get(responseObject)}")
            }
          }
        case None =>
          println("No response received")
      }
    }
  }

  @throws[Exception]
  def main(args: Array[String]): Unit = {
    try {
      val environment: Environment = INDataCenter.PRODUCTION
      val token: Token = new OAuthToken.Builder()
        .clientID("client_id")
        .clientSecret("client_secret")
        .grantToken("grant_token")
        .build()
      new Initializer.Builder()
        .environment(environment)
        .token(token)
        .initialize()

      enableBaseCurrency()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}