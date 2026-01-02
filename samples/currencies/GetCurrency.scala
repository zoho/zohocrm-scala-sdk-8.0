package samples.currencies

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.currencies.{APIException, CurrenciesOperations, ResponseHandler, ResponseWrapper}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse

object GetCurrency {

  @throws[Exception]
  private def getCurrency(): Unit = {
    val currencyId = 1055806000007368016L // Replace with actual currency ID
    val currenciesOperations = new CurrenciesOperations()
    val response: Option[APIResponse[ResponseHandler]] = currenciesOperations.getCurrency(currencyId)

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          
          if (List(204, 304).contains(apiResponse.getStatusCode)) {
            println(if (apiResponse.getStatusCode == 204) "No Content" else "Not Modified")
            return
          }

          if (apiResponse.isExpected) {
            val responseHandler = apiResponse.getObject

            responseHandler match {
              case responseWrapper: ResponseWrapper =>
                val currencies = responseWrapper.getCurrencies()
                if (currencies != null && currencies.nonEmpty) {
                  currencies.foreach { currency =>
                    println(s"Currency ID: ${currency.getId()}")
                    if (currency.getIsoCode().isDefined) {
                      println(s"Currency ISO Code: ${currency.getIsoCode().get}")
                    }
                    if (currency.getSymbol().isDefined) {
                      println(s"Currency Symbol: ${currency.getSymbol().get}")
                    }
                    if (currency.getCreatedTime().isDefined) {
                      println(s"Currency CreatedTime: ${currency.getCreatedTime().get}")
                    }
                    if (currency.getModifiedTime().isDefined) {
                      println(s"Currency ModifiedTime: ${currency.getModifiedTime().get}")
                    }
                    if (currency.getName().isDefined) {
                      println(s"Currency Name: ${currency.getName().get}")
                    }
                    if (currency.getModifiedBy().isDefined) {
                      val modifiedBy = currency.getModifiedBy().get
                      println(s"Currency Modified By User-ID: ${modifiedBy.getId()}")
                      if (modifiedBy.getName().isDefined) {
                        println(s"Currency Modified By User-Name: ${modifiedBy.getName().get}")
                      }
                      if (modifiedBy.getEmail().isDefined) {
                        println(s"Currency Modified By User-Email: ${modifiedBy.getEmail().get}")
                      }
                    }
                    if (currency.getCreatedBy().isDefined) {
                      val createdBy = currency.getCreatedBy().get
                      println(s"Currency Created By User-ID: ${createdBy.getId()}")
                      if (createdBy.getName().isDefined) {
                        println(s"Currency Created By User-Name: ${createdBy.getName().get}")
                      }
                      if (createdBy.getEmail().isDefined) {
                        println(s"Currency Created By User-Email: ${createdBy.getEmail().get}")
                      }
                    }
                    if (currency.getExchangeRate().isDefined) {
                      println(s"Currency Exchange Rate: ${currency.getExchangeRate().get}")
                    }
                    if (currency.getFormat().isDefined) {
                      val format = currency.getFormat().get
                      if (format.getDecimalSeparator() != null) {
                        println(s"Currency Format Decimal Separator: ${format.getDecimalSeparator().getValue}")
                      }
                      if (format.getThousandSeparator() != null) {
                        println(s"Currency Format Thousand Separator: ${format.getThousandSeparator().getValue}")
                      }
                      if (format.getDecimalPlaces() != null) {
                        println(s"Currency Format Decimal Places: ${format.getDecimalPlaces().getValue}")
                      }
                    }
                    if (currency.getIsActive().isDefined) {
                      println(s"Currency IsActive: ${currency.getIsActive().get}")
                    }
                    if (currency.getIsBase().isDefined) {
                      println(s"Currency IsBase: ${currency.getIsBase().get}")
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
                println("Unexpected response handler")
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

      getCurrency()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}