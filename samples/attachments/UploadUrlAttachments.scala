package samples.attachments

import com.zoho.api.authenticator.OAuthToken
import com.zoho.api.authenticator.Token
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.attachments.{ActionHandler, ActionResponse, ActionWrapper, APIException, AttachmentsOperations, SuccessResponse}
import com.zoho.crm.api.attachments.AttachmentsOperations.UploadUrlAttachmentsParam
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.ParameterMap

object UploadUrlAttachments {

  @throws[Exception]
  private def uploadUrlAttachments(): Unit = {
    val module = "Leads"
    val recordId: Long = 1055806000028638063L // Replace with actual record ID
    val attachmentsOperations = new AttachmentsOperations()
    val paramInstance = new ParameterMap()
    paramInstance.add(new UploadUrlAttachmentsParam().attachmentUrl, "https://example.com/sample-document.pdf")
    val response: Option[APIResponse[ActionHandler]] = attachmentsOperations.uploadUrlAttachments(recordId, module, Some(paramInstance))
    response match {
      case Some(apiResponse) =>
        println(s"Status Code: ${apiResponse.getStatusCode}")
        if (apiResponse.isExpected) {
          val responseHandler: ActionHandler = apiResponse.getObject
          responseHandler match {
            case actionWrapper: ActionWrapper =>
              val actionResponses: List[ActionResponse] = actionWrapper.getData().toList
              actionResponses.foreach {
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
              }
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
          }
        } else {
          val responseObject: Any = apiResponse.getModel
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
      uploadUrlAttachments()
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }
}