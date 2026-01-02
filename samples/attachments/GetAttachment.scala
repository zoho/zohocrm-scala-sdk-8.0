package samples.attachments

import com.zoho.api.authenticator.OAuthToken
import com.zoho.api.authenticator.Token
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.attachments.{APIException, AttachmentsOperations, FileBodyWrapper, ResponseHandler}
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.dc.DataCenter.Environment
import java.io.{File, FileOutputStream}

object GetAttachment {

  @throws[Exception]
  private def getAttachment(): Unit = {
    val module = "Leads"
    val destinationFolder = "./"
    val recordId: Long = 1055806000028638063L // Replace with actual record ID
    val attachmentId: Long = 1055806000028728001L // Replace with actual attachment ID
    val attachmentsOperations = new AttachmentsOperations()
    val response: Option[APIResponse[ResponseHandler]] = attachmentsOperations.getAttachment(attachmentId, recordId, module)
    response match {
      case Some(apiResponse) =>
        println(s"Status Code: ${apiResponse.getStatusCode}")
        if (List(204, 304).contains(apiResponse.getStatusCode)) {
          println(if (apiResponse.getStatusCode == 204) "No Content" else "Not Modified")
          return
        }
        if (apiResponse.isExpected) {
          val responseHandler: ResponseHandler = apiResponse.getObject
          responseHandler match {
            case fileBodyWrapper: FileBodyWrapper =>
              val fileBodyWrapper = responseHandler.asInstanceOf[FileBodyWrapper]
              val streamWrapper = fileBodyWrapper.getFile().get
              val file = new File(destinationFolder + java.io.File.separatorChar + streamWrapper.getName)
              val is = streamWrapper.getStream.get
              val os = new FileOutputStream(file)
              val buffer = new Array[Byte](1024)
              var bytesRead: Integer = 0
              while ( {
                bytesRead = is.read(buffer)
                bytesRead != -1
              }) {
                os.write(buffer, 0, bytesRead)
              }
              is.close()
              os.flush()
              os.close()
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
        } else if (apiResponse.getStatusCode != 204) {
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
      getAttachment()
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }
}