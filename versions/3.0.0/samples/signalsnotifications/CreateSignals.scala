package samples.signalsnotifications

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.dc.{DataCenter, USDataCenter}
import com.zoho.crm.api.signalsnotifications._
import com.zoho.crm.api.util.{APIResponse, Model}

import scala.collection.mutable.ArrayBuffer
import scala.jdk.CollectionConverters._

object CreateSignals {

  @throws[Exception]
  private def createSignals(): Unit = {
    val signalsNotificationsOperations = new SignalsNotificationsOperations()
    val bodyWrapper = new BodyWrapper()
    val signals = ArrayBuffer(
      new Signals() {
        setSignalNamespace(Option("mailchimp.open"))
        setSubject(Option("Java SDK Test"))
        setId(Option(34770605001L))
        setModule(Option("Leads"))
        setMessage(Option("This is SDK sample code"))
      }
    )

    bodyWrapper.setSignals(signals)

    val response= signalsNotificationsOperations.createSignals(bodyWrapper)

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          if (apiResponse.getStatusCode == 204) {
            println("No Content")
            return
          }
          if (apiResponse.isExpected) {
            val actionHandler = apiResponse.getObject

            actionHandler match {
              case actionWrapper: ActionWrapper =>
                val actionResponses = actionWrapper.getSignals()
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
                    println(s"Message: ${successResponse.getMessage().getValue}")

                  case exception: APIException =>
                    println(s"Status: ${exception.getStatus().getValue}")
                    println(s"Code: ${exception.getCode().getValue}")
                    println("Details: ")
                    exception.getDetails().foreach { details =>
                      details.foreach { case (key, value) =>
                        println(s"$key: $value")
                      }
                    }
                    println(s"Message: ${exception.getMessage().getValue}")
                }

              case exception: APIException =>
                println(s"Status: ${exception.getStatus().getValue}")
                println(s"Code: ${exception.getCode().getValue}")
                println("Details: ")
                exception.getDetails().foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"$key: $value")
                  }
                }
                println(s"Message: ${exception.getMessage().getValue}")

              case _ => println("Unexpected response type.")
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
      }
    }
  }

  @throws[Exception]
  def main(args: Array[String]): Unit = {
    try {
      val environment: DataCenter.Environment = USDataCenter.PRODUCTION
      val token: Token = new OAuthToken.Builder()
        .clientID("Client_Id")
        .clientSecret("Client_Secret")
        .refreshToken("Refresh_Token")
        .build()

      new Initializer.Builder()
        .environment(environment)
        .token(token)
        .initialize()

      createSignals()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
