package samples.massdeletetags

import java.lang.reflect.Field
import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.{INDataCenter, USDataCenter}
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.massdeletetags.{APIException, ActionResponse, BodyWrapper, MassDelete, MassDeleteDetails, MassDeleteTagsOperations, Module, StatusResponseHandler, StatusResponseWrapper, SuccessResponse, Tag}
import com.zoho.crm.api.util.Model

import scala.collection.mutable.ArrayBuffer

object MassDeleteTags {

  def massDeleteTags(): Unit = {
    val massDeleteTagsOperations = new MassDeleteTagsOperations()
    val request = new BodyWrapper()
    val massDelete = new ArrayBuffer[MassDelete]()

    val massDelete1 = new MassDelete()
    val module = new Module()
    module.setAPIName(Option("Leads"))
    module.setId(Option(753477000037L))
    massDelete1.setModule(Option(module))

    val tags = new ArrayBuffer[Tag]()
    val tag1 = new Tag()
    tag1.setId(Option(75347700326987L))
    tags.addOne(tag1)
    val tag2 = new Tag()
    tag2.setId(Option(753477326988L))
    tags.addOne(tag2)
    massDelete1.setTags(tags)

    massDelete.addOne(massDelete1)
    request.setMassDelete(massDelete)

    val response: Option[APIResponse[ActionResponse]] = massDeleteTagsOperations.massDeleteTags(request)

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.isExpected) {
            apiResponse.getObject match {
              case successResponse: SuccessResponse =>
                println(s"Status: ${successResponse.getStatus.getValue}")
                println(s"Code: ${successResponse.getCode.getValue}")
                println("Details: ")
                successResponse.getDetails.foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"$key: $value")
                  }
                }
                println(s"Message: ${successResponse.getMessage}")

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
            }
          } else {
            val responseObject = apiResponse.getModel
            val fields = responseObject.getClass.getDeclaredFields
            for (field <- fields) {
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

      massDeleteTags()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
