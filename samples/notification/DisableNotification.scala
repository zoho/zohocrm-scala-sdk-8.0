package samples.notification

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.notifications.{ActionHandler, ActionWrapper, APIException, BodyWrapper, Notification, NotificationsOperations, SuccessResponse}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse

import scala.collection.mutable.ArrayBuffer

object DisableNotification {

  @throws[Exception]
  private def disableNotification(): Unit = {
    val notificationsOperations = new NotificationsOperations()
    val notifications = new ArrayBuffer[Notification]()
    // Create notification to disable
    val notification = new Notification()
    notification.setChannelId(Option("1000000068001")) // Replace with actual channel ID
    notification.setNotifyOnRelatedAction(Option(false))
    // Optionally set specific events to disable
    val deleteEvents = new ArrayBuffer[String]()
    deleteEvents.addAll(Array("Leads.all", "Contacts.all", "Deals.all"))
    notification.setEvents(deleteEvents)
    notification.setDeleteEvents(Option(true))
    notifications.addOne(notification)
    val request = new BodyWrapper()
    request.setWatch(notifications)
    val response: Option[APIResponse[ActionHandler]] = notificationsOperations.disableNotification(request)

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          
          if (apiResponse.isExpected) {
            val actionHandler = apiResponse.getObject

            actionHandler match {
              case actionWrapper: ActionWrapper =>
                val actionResponses = actionWrapper.getWatch()
                if (actionResponses != null) {
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
                      if (successResponse.getMessage() != null) {
                        println(s"Message: ${successResponse.getMessage().getValue}")
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
                      println("Unexpected action response type")
                  }
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

      disableNotification()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}