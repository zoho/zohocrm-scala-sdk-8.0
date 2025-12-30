package samples.notification

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.notifications.{ActionHandler, ActionWrapper, APIException, BodyWrapper, Notification, NotificationsOperations, SuccessResponse}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse

import scala.collection.mutable.ArrayBuffer

object EnableNotifications {

  @throws[Exception]
  private def enableNotifications(): Unit = {
    val notificationsOperations = new NotificationsOperations()
    val notifications = new ArrayBuffer[Notification]()
    
    // Create first notification
    val notification1 = new Notification()
    notification1.setChannelId(Option("1000000068001")) // Replace with actual channel ID
    notification1.setNotifyUrl(Option("https://www.example.com/notifications"))
    notification1.setNotifyOnRelatedAction(Option(true))
    
    val events1 = new ArrayBuffer[String]()
    events1.addAll(Array("Leads.all", "Contacts.create", "Deals.edit"))
    notification1.setEvents(events1)
    notification1.setToken(Option("notification_token_123"))
    
    notifications.addOne(notification1)
    
    // Create second notification
    val notification2 = new Notification()
    notification2.setChannelId(Option("1000000068002")) // Replace with actual channel ID
    notification2.setNotifyUrl(Option("https://www.example.com/webhook"))
    notification2.setNotifyOnRelatedAction(Option(false))
    
    val events2 = new ArrayBuffer[String]()
    events2.addAll(Array("Accounts.all", "Products.create"))
    notification2.setEvents(events2)
    notification2.setToken(Option("webhook_token_456"))
    
    notifications.addOne(notification2)
    
    val request = new BodyWrapper()
    request.setWatch(notifications)
    
    val response: Option[APIResponse[ActionHandler]] = notificationsOperations.enableNotifications(request)

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
      enableNotifications()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}