package samples.sharerecords

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.sharerecords.{APIException, ActionHandler, ActionWrapper, BodyWrapper, ShareRecord, ShareRecordsOperations, SuccessResponse}
import com.zoho.crm.api.util.{APIResponse, Choice}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.users.Users

import scala.collection.mutable.ArrayBuffer

object UpdateSharePermissions {

  @throws[Exception]
  private def updateSharePermissions(recordId: Long, moduleAPIName: String): Unit = {
    val shareRecordsOperations = new ShareRecordsOperations(recordId, moduleAPIName)
    val request = new BodyWrapper()
    val shareRecords = new ArrayBuffer[ShareRecord]()

    // Create share record for User 1
    val shareRecord1 = new ShareRecord()
    shareRecord1.setShareRelatedRecords(Option(true))
    shareRecord1.setPermission(Option("full_access"))

    val sharedWith = new Users()
    sharedWith.setId(Option(1055806000017236002L))
    sharedWith.addKeyValue("type", "groups")
    shareRecord1.setSharedWith(Option(sharedWith))
    shareRecord1.setType(new Choice("private"))
    shareRecords += shareRecord1
    request.setShare(shareRecords)

    val response: Option[APIResponse[ActionHandler]] = shareRecordsOperations.updateSharePermissions(request)

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.isExpected) {
            val actionHandler = apiResponse.getObject

            actionHandler match {
              case actionWrapper: ActionWrapper =>
                val actionResponses = actionWrapper.getShare()
                if (actionResponses != null) {
                  actionResponses.foreach {
                    case successResponse: SuccessResponse =>
                      println(s"Status: ${successResponse.getStatus().getValue}")
                      println(s"Code: ${successResponse.getCode().getValue}")
                      println(s"Details:")
                      successResponse.getDetails().foreach { details =>
                        details.foreach { case (key, value) =>
                          println(s"  $key -> $value")
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
                println(s"Message: ${exception.getMessage().getValue}")

              case _ =>
                println("Unexpected action handler")
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
          println("No response received from UpdateSharePermissions API.")
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

      val recordId = 1055806000028754070L  // Record ID to update share permissions for
      val moduleAPIName = "Leads"     // Module API name
      updateSharePermissions(recordId, moduleAPIName)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}