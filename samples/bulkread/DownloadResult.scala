package samples.bulkread

import java.io.{File, FileOutputStream}
import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.bulkread.{APIException, BulkReadOperations, FileBodyWrapper, ResponseHandler}
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.util.APIResponse

object DownloadResult {

  private def downloadResult(): Unit = {
    val jobId: Long = 1055806000028743001L // Replace with actual job ID
    val destinationFolder = "./" // Replace with actual destination folder
    val bulkReadOperations = new BulkReadOperations()
    val response: Option[APIResponse[ResponseHandler]] = bulkReadOperations.downloadResult(jobId)
    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          if (List(204, 304).contains(apiResponse.getStatusCode)) {
            println(if (apiResponse.getStatusCode == 204) "No Content" else "Not Modified")
            return
          }
          if (apiResponse.isExpected) {
            apiResponse.getObject match {
              case fileBodyWrapper: FileBodyWrapper =>
                val fileBodyWrapper = apiResponse.getObject.asInstanceOf[FileBodyWrapper]
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

      downloadResult()
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }
}