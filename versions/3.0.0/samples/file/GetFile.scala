package samples.files

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.files.FilesOperations.GetFileParam
import com.zoho.crm.api.files.{APIException, FileBodyWrapper, FilesOperations, ResponseHandler}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse
import java.io.{File, FileOutputStream}

object GetFile {

  @throws[Exception]
  private def getFile(): Unit = {
    val fileId = "68fe84c2f07beb40cf93b566cf6c" // Replace with actual file ID
    val destinationFolder = "./"
    val filesOperations = new FilesOperations()
    val paramInstance = new ParameterMap()
    
    // Add file ID parameter
    paramInstance.add(new GetFileParam().id, fileId)
    
    val response: Option[APIResponse[ResponseHandler]] = filesOperations.getFile(Option(paramInstance))

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
              case fileBodyWrapper: FileBodyWrapper =>
                val streamWrapperOption = fileBodyWrapper.getFile()
                if (streamWrapperOption.isDefined) {
                  val streamWrapper = streamWrapperOption.get
                  val fileName = streamWrapper.getName.get
                  val file = new File(destinationFolder + java.io.File.separatorChar + fileName)
                  
                  val inputStreamOption = streamWrapper.getStream
                  if (inputStreamOption.isDefined) {
                    val inputStream = inputStreamOption.get
                    val outputStream = new FileOutputStream(file)
                    
                    try {
                      val buffer = new Array[Byte](1024)
                      var bytesRead: Int = 0
                      while ({
                        bytesRead = inputStream.read(buffer)
                        bytesRead != -1
                      }) {
                        outputStream.write(buffer, 0, bytesRead)
                      }
                      println(s"File downloaded successfully: ${file.getAbsolutePath}")
                    } finally {
                      inputStream.close()
                      outputStream.flush()
                      outputStream.close()
                    }
                  } else {
                    println("No file stream available")
                  }
                } else {
                  println("No file data available")
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

      getFile()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}