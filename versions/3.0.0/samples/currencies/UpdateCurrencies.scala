package samples.currencies

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.currencies.{ActionHandler, ActionWrapper, APIException, BodyWrapper, CurrenciesOperations, Currency, SuccessResponse}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse

import scala.collection.mutable.ArrayBuffer

object UpdateCurrencies {

  @throws[Exception]
  private def updateCurrencies(): Unit = {
    val currenciesOperations = new CurrenciesOperations()
    val request = new BodyWrapper()
    val currencies = new ArrayBuffer[Currency]()
    val currency1 = new Currency()
    
    currency1.setId(Option(1055806000000000001L)) // Replace with actual currency ID
    currency1.setExchangeRate(Option("28.33"))
    currency1.setIsActive(Option(true))
    
    currencies.addOne(currency1)
    request.setCurrencies(currencies)
    
    val response: Option[APIResponse[ActionHandler]] = currenciesOperations.updateCurrencies(request)

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.isExpected) {
            val actionHandler = apiResponse.getObject

            actionHandler match {
              case actionWrapper: ActionWrapper =>
                val actionResponses = actionWrapper.getCurrencies()
                if (actionResponses != null) {
                  actionResponses.foreach { actionResponse =>
                    actionResponse match {
                      case successResponse: SuccessResponse =>
                        println(s"Status: ${successResponse.getStatus().getValue}")
                        println(s"Code: ${successResponse.getCode().getValue}")
                        println("Details: ")
                        successResponse.getDetails().foreach { details =>
                          details.foreach { case (key, value) =>
                            println(s"$key: $value")
                            if (key == "id") {
                              println(s"Currency updated successfully. Currency ID: $value")
                            }
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

                      case _ =>
                        println("Unexpected action response")
                    }
                    println("--------------------")
                  }
                }

              case exception: APIException =>
                println(s"Status: ${exception.getStatus().getValue}")
                println(s"Code: ${exception.getCode().getValue}")
                exception.getDetails().foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"$key: $value")
                  }
                }
                println(s"Message: ${exception.getMessage()}")

              case _ =>
                println("Unexpected action handler")
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

      updateCurrencies()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}