package samples.record

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.record.{APIException, FileHandler, RecordOperations, SuccessResponse}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.util.APIResponse

object DeletePhoto {

  @throws[Exception]
  private def deletePhoto(moduleAPIName: String, recordId: Long): Unit = {
    val recordOperations = new RecordOperations(moduleAPIName)

    val response: Option[APIResponse[FileHandler]] = recordOperations.deletePhoto(recordId)

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

        case None => println("No response from the DeletePhoto API.")
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
      val recordId = 1055806000028812002L
      
      deletePhoto(moduleAPIName, recordId)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}