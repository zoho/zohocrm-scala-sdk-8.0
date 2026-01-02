package samples.bulkwrite

import java.io.File
import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.bulkwrite.{APIException, ActionResponse, BulkWriteOperations, FileBodyWrapper, SuccessResponse}
import com.zoho.crm.api.bulkwrite.BulkWriteOperations.UploadFileHeader
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.util.{APIResponse, StreamWrapper}
import com.zoho.crm.api.HeaderMap

object UploadFile {

  private def uploadFile(): Unit = {
    val absoluteFilePath = "./Leads.zip"
    val bulkWriteOperations = new BulkWriteOperations
    val fileBodyWrapper = new FileBodyWrapper
    val streamWrapper = new StreamWrapper(absoluteFilePath)
    fileBodyWrapper.setFile(Option(streamWrapper))
    val headerInstance = new HeaderMap
    headerInstance.add(new UploadFileHeader().feature, "bulk-write")
    headerInstance.add(new UploadFileHeader().XCRMORG, "org_id")
    val response: Option[APIResponse[ActionResponse]] = bulkWriteOperations.uploadFile(fileBodyWrapper, Option(headerInstance))
    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.isExpected) {
            apiResponse.getObject match {
              case successResponse: SuccessResponse =>
                println(s"Status: ${successResponse.getStatus().getValue}")
                println(s"Code: ${successResponse.getCode().getValue}")
                println("Details: ")
                successResponse.getDetails().foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"$key: $value")
                    if (key == "file_id") {
                      println(s"File uploaded successfully. File ID: $value")
                    }
                  }
                }
                println(s"Message: ${successResponse.getMessage().getValue}")

              case exception: APIException =>
                println(s"Status: ${exception.getStatus().getValue}")
                println(s"Code: ${exception.getCode().getValue}")
                println("Details: ")
                exception.getDetails().foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"$key: $value")
                  }
                }
                println(s"Message: ${exception.getMessage().getValue}")
                
              case _ =>
                println("Unexpected response type received")
            }
          } else {
            val responseObject = apiResponse.getModel
            val fields = responseObject.getClass.getDeclaredFields
            for (field <- fields) {
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

      uploadFile()
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }
}