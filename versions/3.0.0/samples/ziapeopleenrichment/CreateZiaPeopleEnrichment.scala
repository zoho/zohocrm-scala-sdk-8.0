package samples.ziapeopleenrichment

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.dc.USDataCenter
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.util.Model
import com.zoho.crm.api.ziapeopleenrichment.ZiaPeopleEnrichmentOperations.CreateZiaPeopleEnrichmentParam
import com.zoho.crm.api.ziapeopleenrichment.{ActionWrapper, SuccessResponse, APIException, ActionHandler, BodyWrapper, Company, EnrichBasedOn, Social, ZiaPeopleEnrichment, ZiaPeopleEnrichmentOperations}

import scala.collection.mutable.ArrayBuffer


object CreateZiaPeopleEnrichment {

  @throws[Exception]
  def createZiaPeopleEnrichment(): Unit = {
    val ziaPeopleEnrichmentOperations = new ZiaPeopleEnrichmentOperations()
    val request = new BodyWrapper()

    val enrichBasedOn = new EnrichBasedOn()
    enrichBasedOn.setName(Option("zoho"))
    enrichBasedOn.setEmail(Option("sales@zohocorp.com"))

    val company = new Company()
    company.setName(Option("zoho"))
    company.setWebsite(Option("www.zoho.com"))
    enrichBasedOn.setCompany(Option(company))

    val social = new Social()
    social.setFacebook(Option("facebook.com/zoho"))
    social.setLinkedin(Option("linkedin.com/zoho"))
    social.setTwitter(Option("twitter.com/zoho"))
    enrichBasedOn.setSocial(Option(social))

    val ziaPeopleEnrichment = new ZiaPeopleEnrichment()
    ziaPeopleEnrichment.setEnrichBasedOn(Option(enrichBasedOn))

    request.setZiaPeopleEnrichment(ArrayBuffer(ziaPeopleEnrichment))

    val paramInstance = new ParameterMap()
    paramInstance.add(new CreateZiaPeopleEnrichmentParam().module, "Vendors")

    val response: Option[APIResponse[ActionHandler]] = ziaPeopleEnrichmentOperations.createZiaPeopleEnrichment(request, Option(paramInstance))

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.isExpected) {
            apiResponse.getObject match {
              case actionWrapper: ActionWrapper =>
                actionWrapper.getZiaPeopleEnrichment().foreach {
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

      createZiaPeopleEnrichment()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
