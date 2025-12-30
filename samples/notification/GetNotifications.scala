package samples.notification

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.notifications.NotificationsOperations.GetNotificationsParam
import com.zoho.crm.api.notifications.{APIException, NotificationsOperations, ResponseHandler, ResponseWrapper}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse

object GetNotifications {

  @throws[Exception]
  private def getNotifications(): Unit = {
    val notificationsOperations = new NotificationsOperations()
    val paramInstance = new ParameterMap()
    paramInstance.add(new GetNotificationsParam().page, 1)
    paramInstance.add(new GetNotificationsParam().perPage, 50)
    paramInstance.add(new GetNotificationsParam().channelId, 1000000068001L) // Replace with actual channel ID
    paramInstance.add(new GetNotificationsParam().module, "Leads")
    
    val response: Option[APIResponse[ResponseHandler]] = notificationsOperations.getNotifications(Option(paramInstance))

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
              case responseWrapper: ResponseWrapper =>
                val notifications = responseWrapper.getWatch()
                if (notifications != null) {
                  notifications.foreach { notification =>
                    println(s"Notification ChannelId: ${notification.getChannelId()}")
                    
                    if (notification.getNotifyUrl().isDefined) {
                      println(s"Notification URL: ${notification.getNotifyUrl().get}")
                    }
                    if (notification.getNotifyOnRelatedAction().isDefined) {
                      println(s"Notify on Related Action: ${notification.getNotifyOnRelatedAction().get}")
                    }
                    if (notification.getChannelId().isDefined) {
                      println(s"Channel ID: ${notification.getChannelId().get}")
                    }
                    if (notification.getEvents() != null && notification.getEvents().nonEmpty) {
                      println("Events:")
                      notification.getEvents().foreach { event =>
                        println(s"  Event: ${event}")
                      }
                    }
                    if (notification.getToken().isDefined) {
                      println(s"Token: ${notification.getToken().get}")
                    }
                    if (notification.getChannelExpiry().isDefined) {
                      println(s"Channel Expiry: ${notification.getChannelExpiry().get}")
                    }
                    if (notification.getResourceUri().isDefined) {
                      println(s"Resource URI: ${notification.getResourceUri().get}")
                    }
                    println("--------------------")
                  }
                }

                val info = responseWrapper.getInfo()
                if (info.isDefined) {
                  val infoData = info.get
                  if (infoData.getCount().isDefined) {
                    println(s"Total Count: ${infoData.getCount().get}")
                  }
                  if (infoData.getPage().isDefined) {
                    println(s"Current Page: ${infoData.getPage().get}")
                  }
                  if (infoData.getPerPage().isDefined) {
                    println(s"Per Page: ${infoData.getPerPage().get}")
                  }
                  if (infoData.getMoreRecords().isDefined) {
                    println(s"More Records Available: ${infoData.getMoreRecords().get}")
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

      getNotifications()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}