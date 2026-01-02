package samples.organization

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.org.{APIException, OrgOperations, ResponseHandler, ResponseWrapper}
import com.zoho.crm.api.util.APIResponse

object GetOrganization {

  @throws[Exception]
  private def getOrganization(): Unit = {
    val orgOperations = new OrgOperations()
    val response: Option[APIResponse[ResponseHandler]] = orgOperations.getOrganization()
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
                val organizations = responseWrapper.getOrg()
                if (organizations != null) {
                  organizations.foreach { organization =>
                    println(s"Organization ID: ${organization.getId()}")
                    
                    if (organization.getCompanyName().isDefined) {
                      println(s"Organization Name: ${organization.getCompanyName().get}")
                    }
                    if (organization.getAlias().isDefined) {
                      println(s"Organization Alias: ${organization.getAlias().get}")
                    }
                    if (organization.getPrimaryZuid().isDefined) {
                      println(s"Primary ZUID: ${organization.getPrimaryZuid().get}")
                    }
                    if (organization.getZgid().isDefined) {
                      println(s"ZGID: ${organization.getZgid().get}")
                    }
                    if (organization.getPrimaryEmail().isDefined) {
                      println(s"Primary Email: ${organization.getPrimaryEmail().get}")
                    }
                    if (organization.getEmployeeCount().isDefined) {
                      println(s"Employee Count: ${organization.getEmployeeCount().get}")
                    }
                    if (organization.getDescription().isDefined) {
                      println(s"Description: ${organization.getDescription().get}")
                    }
                    if (organization.getWebsite().isDefined) {
                      println(s"Website: ${organization.getWebsite().get}")
                    }
                    if (organization.getCurrencySymbol().isDefined) {
                      println(s"Currency Symbol: ${organization.getCurrencySymbol().get}")
                    }
                    if (organization.getCurrencyLocale().isDefined) {
                      println(s"Currency Locale: ${organization.getCurrencyLocale().get}")
                    }
                    if (organization.getTimeZone().isDefined) {
                      println(s"Timezone: ${organization.getTimeZone().get}")
                    }
                    if (organization.getIsoCode().isDefined) {
                      println(s"ISO Code: ${organization.getIsoCode().get}")
                    }
                    if (organization.getMobile().isDefined) {
                      println(s"Mobile: ${organization.getMobile().get}")
                    }
                    if (organization.getPhone().isDefined) {
                      println(s"Phone: ${organization.getPhone().get}")
                    }
                    if (organization.getStreet().isDefined) {
                      println(s"Street: ${organization.getStreet().get}")
                    }
                    if (organization.getCity().isDefined) {
                      println(s"City: ${organization.getCity().get}")
                    }
                    if (organization.getState().isDefined) {
                      println(s"State: ${organization.getState().get}")
                    }
                    if (organization.getCountry().isDefined) {
                      println(s"Country: ${organization.getCountry().get}")
                    }
                    if (organization.getCountryCode().isDefined) {
                      println(s"Country Code: ${organization.getCountryCode().get}")
                    }
                    if (organization.getFax().isDefined) {
                      println(s"Fax: ${organization.getFax().get}")
                    }
                    if (organization.getMcStatus().isDefined) {
                      println(s"MC Status: ${organization.getMcStatus().get}")
                    }
                    if (organization.getGappsEnabled().isDefined) {
                      println(s"Gapps Enabled: ${organization.getGappsEnabled().get}")
                    }
                    if (organization.getTranslationEnabled().isDefined) {
                      println(s"Translation Enabled: ${organization.getTranslationEnabled().get}")
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

      getOrganization()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}