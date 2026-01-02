package samples.organization

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.org.*
import com.zoho.crm.api.util.{APIResponse, StreamWrapper}

object UploadOrganizationPhoto {

  @throws[Exception]
  private def uploadOrganizationPhoto(): Unit = {
    val orgOperations = new OrgOperations()
    val request = new FileBodyWrapper()
    val filePath = "path/to/organization_photo.png"
    val streamWrapper = new StreamWrapper(filePath)
    request.setFile(Option(streamWrapper))
    val response: Option[APIResponse[ActionHandler]] = orgOperations.uploadOrganizationPhoto(request)
    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          if (apiResponse.isExpected) {
            val actionHandler = apiResponse.getObject
            actionHandler match
              case successResponse: SuccessResponse =>
                println(s"Status: ${successResponse.getStatus().getValue}")
                println(s"Code: ${successResponse.getCode().getValue}")
                println("Details: ")
                successResponse.getDetails().foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"$key: $value")
                  }
                }
                if (successResponse.getMessage() != null) {
                  println(s"Message: ${successResponse.getMessage()}")
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
                println("Unexpected action response type")
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

      uploadOrganizationPhoto()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}