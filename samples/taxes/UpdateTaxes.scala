package samples.taxes

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.taxes.{APIException, ActionHandler, ActionWrapper, BodyWrapper, OrgTax, Tax, TaxesOperations}
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.Initializer

import scala.collection.mutable.ArrayBuffer

object UpdateTaxes {

  @throws[Exception]
  private def updateTaxes(): Unit = {
    val taxesOperations = new TaxesOperations()
    val request = new BodyWrapper()
    val orgTax = new OrgTax()
    val taxList = ArrayBuffer[Tax]()

    val tax1 = new Tax()
    tax1.setId(Option(1055806000013468001L)) // Existing tax ID
    tax1.setName(Option("Updated GST"))
    tax1.setValue(Option(18.5)) // Updated tax percentage
    tax1.setSequenceNumber(Option(1))
    taxList += tax1
    orgTax.setTaxes(taxList)
    request.setOrgTaxes(Option(orgTax))

    val response: Option[APIResponse[ActionHandler]] = taxesOperations.updateTaxes(request)

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.isExpected) {
            val actionHandler = apiResponse.getObject

            actionHandler match {
              case actionWrapper: ActionWrapper =>
                val actionResponses = actionWrapper.getOrgTaxes()
                if (actionResponses != null) {
                  actionResponses.foreach {
                    case successResponse: com.zoho.crm.api.taxes.SuccessResponse =>
                      println(s"Status: ${successResponse.getStatus().getValue}")
                      println(s"Code: ${successResponse.getCode().getValue}")

                      if (successResponse.getDetails().isDefined) {
                        val details = successResponse.getDetails().get
                        details.foreach { case (key, value) =>
                          println(s"Details: $key -> $value")
                        }
                      }

                      println(s"Message: ${successResponse.getMessage()}")

                    case exception: APIException =>
                      println(s"Status: ${exception.getStatus().getValue}")
                      println(s"Code: ${exception.getCode().getValue}")
                      exception.getDetails().foreach { details =>
                        details.foreach { case (key, value) =>
                          println(s"Details: $key -> $value")
                        }
                      }
                      println(s"Message: ${exception.getMessage()}")
                  }
                }

              case exception: APIException =>
                println(s"Status: ${exception.getStatus().getValue}")
                println(s"Code: ${exception.getCode().getValue}")
                exception.getDetails().foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"Details: $key -> $value")
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
          println("No response received from UpdateTaxes API.")
      }
    }
  }

  @throws[Exception]
  def main(args: Array[String]): Unit = {
    try {
      val environment: DataCenter.Environment = INDataCenter.PRODUCTION
      val token: Token = new OAuthToken.Builder()
        .clientID("client_id")
        .clientSecret("client_secret")
        .grantToken("grant_token")
        .build()

      new Initializer.Builder()
        .environment(environment)
        .token(token)
        .initialize()

      updateTaxes()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}