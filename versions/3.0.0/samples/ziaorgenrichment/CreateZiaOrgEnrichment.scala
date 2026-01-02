package samples.ziaorgenrichment

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.dc.{INDataCenter, USDataCenter}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.Model
import com.zoho.crm.api.ziaorgenrichment.ZiaOrgEnrichmentOperations.CreateZiaOrgEnrichmentParam
import com.zoho.crm.api.ziaorgenrichment.{ActionWrapper, SuccessResponse, APIException, ActionHandler, BodyWrapper, EnrichBasedOn, ZiaOrgEnrichment, ZiaOrgEnrichmentOperations}

import scala.collection.mutable.ArrayBuffer


object CreateZiaOrgEnrichment {

  @throws[Exception]
  private def createZiaOrgEnrichment(): Unit = {
    val ziaOrgEnrichmentOperations = new ZiaOrgEnrichmentOperations()
    val request = new BodyWrapper()

    val enrichBasedOn = new EnrichBasedOn()
    enrichBasedOn.setName(Option("zoho"))
    enrichBasedOn.setEmail(Option("sales@zohocorp.com"))
    enrichBasedOn.setWebsite(Option("www.zoho.com"))

    val ziaOrgEnrichment = new ZiaOrgEnrichment()
    ziaOrgEnrichment.setEnrichBasedOn(Option(enrichBasedOn))

    request.setZiaOrgEnrichment(ArrayBuffer(ziaOrgEnrichment))

    val paramInstance = new ParameterMap()
    paramInstance.add(new CreateZiaOrgEnrichmentParam().module, "Leads")

    val response: Option[APIResponse[ActionHandler]] = ziaOrgEnrichmentOperations.createZiaOrgEnrichment(request, Option(paramInstance))

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.isExpected) {
            apiResponse.getObject match {
              case actionWrapper: ActionWrapper =>
                actionWrapper.getZiaOrgEnrichment().foreach {
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

                  case apiException: APIException =>
                    println(s"Status: ${apiException.getStatus().getValue}")
                    println(s"Code: ${apiException.getCode().getValue}")
                    println("Details: ")
                    apiException.getDetails().foreach { details =>
                      details.foreach { case (key, value) =>
                        println(s"$key: $value")
                      }
                    }
                    println(s"Message: ${apiException.getMessage().getValue}")
                }

              case apiException: APIException =>
                println(s"Status: ${apiException.getStatus().getValue}")
                println(s"Code: ${apiException.getCode().getValue}")
                println("Details: ")
                apiException.getDetails().foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"$key: $value")
                  }
                }
                println(s"Message: ${apiException.getMessage().getValue}")
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

      createZiaOrgEnrichment()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
