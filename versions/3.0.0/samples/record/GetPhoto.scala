package samples.record

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.record.{APIException, DownloadHandler, FileBodyWrapper, RecordOperations}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.util.APIResponse

import java.io.{File, FileOutputStream}

object GetPhoto {

  @throws[Exception]
  private def getPhoto(moduleAPIName: String, recordId: Long, destinationFolder: String): Unit = {
    val recordOperations = new RecordOperations(moduleAPIName)
    val response: Option[APIResponse[DownloadHandler]] = recordOperations.getPhoto(recordId)
    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.getStatusCode == 204) {
            println("No Content - Record photo not found")
            return
          }

          if (apiResponse.isExpected) {
            val responseHandler = apiResponse.getObject
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
          } else {
            val responseObject = apiResponse.getModel
            val clazz = responseObject.getClass
            val fields = clazz.getDeclaredFields
            fields.foreach { field =>
              field.setAccessible(true)
              println(s"${field.getName}: ${field.get(responseObject)}")
            }
          }

        case None => println("No response from the GetPhoto API.")
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

      val moduleAPIName = "Leads"
      val recordId = 1055806000028754072L
      val destinationFolder = "./"
      
      getPhoto(moduleAPIName, recordId, destinationFolder)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}