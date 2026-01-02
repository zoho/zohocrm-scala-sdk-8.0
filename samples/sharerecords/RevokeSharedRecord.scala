package samples.sharerecords

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.sharerecords.{APIException, DeleteActionHandler, DeleteActionWrapper, ShareRecordsOperations, SuccessResponse}
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.Initializer

object RevokeSharedRecord {

  @throws[Exception]
  private def revokeSharedRecord(recordId: Long, moduleAPIName: String): Unit = {
    val shareRecordsOperations = new ShareRecordsOperations(recordId, moduleAPIName)
    
    val response: Option[APIResponse[DeleteActionHandler]] = shareRecordsOperations.revokeSharedRecord()

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.isExpected) {
            val deleteActionHandler = apiResponse.getObject

            deleteActionHandler match {
              case deleteActionWrapper: DeleteActionWrapper =>
                val deleteActionResponses = deleteActionWrapper.getShare()
                if (deleteActionResponses != null) {
                  deleteActionResponses.foreach {
                    case successResponse: SuccessResponse =>
                      println(s"Status: ${successResponse.getStatus().getValue}")
                      println(s"Code: ${successResponse.getCode().getValue}")
                      println(s"Details:")
                      successResponse.getDetails().foreach { details =>
                        details.foreach { case (key, value) =>
                          println(s"  $key -> $value")
                        }
                      }
                      println(s"Message: ${successResponse.getMessage()}")

                    case exception: APIException =>
                      println(s"Status: ${exception.getStatus().getValue}")
                      println(s"Code: ${exception.getCode().getValue}")
                      exception.getDetails().foreach { details =>
                        details.foreach { case (key, value) =>
                          println(s"Details: $key -> $value")
                        }
                      }
                      println(s"Message: ${exception.getMessage()}")
                  }
                }

              case exception: APIException =>
                println(s"Status: ${exception.getStatus().getValue}")
                println(s"Code: ${exception.getCode().getValue}")
                exception.getDetails().foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"Details: $key -> $value")
                  }
                }
                println(s"Message: ${exception.getMessage()}")

              case _ =>
                println("Unexpected delete action handler")
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
          println("No response received from RevokeSharedRecord API.")
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

      val recordId = 1055806000028754070L  // Record ID to revoke shared access for
      val moduleAPIName = "Leads"     // Module API name
      revokeSharedRecord(recordId, moduleAPIName)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}