package samples.record

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.{Initializer, ParameterMap}
import com.zoho.crm.api.record.{APIException, FileBodyWrapper, FileHandler, RecordOperations, SuccessResponse}
import com.zoho.crm.api.record.RecordOperations.UploadPhotoParam
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.util.{APIResponse, StreamWrapper}

import java.io.{File, FileInputStream}

object UploadPhoto {

  @throws[Exception]
  private def uploadPhoto(moduleAPIName: String, recordId: Long, filePath: String): Unit = {
    val recordOperations = new RecordOperations(moduleAPIName)
    val fileBodyWrapper = new FileBodyWrapper()
    
    // Prepare the file to upload
    val file = new File(filePath)
    val fileInputStream = new FileInputStream(file)
    val streamWrapper = new StreamWrapper(filePath)
    fileBodyWrapper.setFile(Option(streamWrapper))
    
    val paramInstance = new ParameterMap()
    paramInstance.add(new UploadPhotoParam().restrictTriggers, "workflow")

    val response: Option[APIResponse[FileHandler]] = recordOperations.uploadPhoto(recordId, fileBodyWrapper, Option(paramInstance))

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.isExpected) {
            val fileHandler = apiResponse.getObject

            fileHandler match {
              case successResponse: SuccessResponse =>
                println(s"Status: ${successResponse.getStatus().getValue}")
                println(s"Code: ${successResponse.getCode().getValue}")

                successResponse.getDetails().foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"Details: $key -> $value")
                  }
                }

                println(s"Message: ${successResponse.getMessage().getValue}")

              case exception: APIException =>
                println(s"Status: ${exception.getStatus().getValue}")
                println(s"Code: ${exception.getCode().getValue}")

                exception.getDetails().foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"Details: $key -> $value")
                  }
                }

                println(s"Message: ${exception.getMessage().getValue}")

              case _ => println("Unexpected file handler type.")
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

        case None => println("No response from the UploadPhoto API.")
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
      val filePath = "./download.png"
      
      uploadPhoto(moduleAPIName, recordId, filePath)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}