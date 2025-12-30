package samples.taxes

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.taxes.{APIException, OrgTax, ResponseHandler, ResponseWrapper, TaxesOperations}
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.Initializer

object GetTaxes {

  @throws[Exception]
  private def getTaxes(): Unit = {
    val taxesOperations = new TaxesOperations()
    
    val response: Option[APIResponse[ResponseHandler]] = taxesOperations.getTaxes()

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
                val orgTax: OrgTax = responseWrapper.getOrgTaxes().get
                val taxes = orgTax.getTaxes()
                if (taxes != null) {
                  println(s"Found ${taxes.size} taxes:")
                  
                  taxes.foreach { tax =>
                    println(s"Tax ID: ${tax.getId()}")
                    
                    if (tax.getName().isDefined) {
                      println(s"Tax Name: ${tax.getName().get}")
                    }
                    
                    if (tax.getDisplayLabel().isDefined) {
                      println(s"Display Label: ${tax.getDisplayLabel().get}")
                    }
                    
                    if (tax.getValue().isDefined) {
                      println(s"Tax Value: ${tax.getValue().get}%")
                    }
                    println("--------------------")
                  }
                } else {
                  println("No taxes found.")
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
          println("No response received from GetTaxes API.")
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

      getTaxes()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}