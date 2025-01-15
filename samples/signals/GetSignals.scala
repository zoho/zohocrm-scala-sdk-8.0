package samples.signals

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.dc.{USDataCenter, DataCenter}
import com.zoho.crm.api.signals._
import com.zoho.crm.api.util.{APIResponse, Model}

import scala.jdk.CollectionConverters._

object GetSignals {

  @throws[Exception]
  def getSignals(): Unit = {
    val signalsOperations = new SignalsOperations()
    val response= signalsOperations.getSignals()

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          if (apiResponse.getStatusCode == 204) {
            println("No Content")
            return
          }
          if (apiResponse.isExpected) {
            val responseHandler = apiResponse.getObject

            responseHandler match {
              case responseWrapper: ResponseWrapper =>
                val signals = responseWrapper.getSignals
                signals.foreach { signal =>
                  println(s"Signals DisplayLabel: ${signal.getDisplayLabel}")
                  val extension = signal.getExtension.get
                  if (extension != null) {
                    println(s"Signals Extension DisplayLabel: ${extension.getDisplayLabel}")
                    println(s"Signals Extension Namespace: ${extension.getNamespace}")
                    println(s"Signals Extension Id: ${extension.getId}")
                    println(s"Signals Extension Type: ${extension.getType}")
                  }

                  val featureAvailability = signal.getFeatureAvailability.get
                  if (featureAvailability != null) {
                    println(s"Signals FeatureAvailability Scoring: ${featureAvailability.getScoring}")
                    println(s"Signals FeatureAvailability Signals: ${featureAvailability.getSignals}")
                  }

                  println(s"Signals Namespace: ${signal.getNamespace}")
                  println(s"Signals ChatEnabled: ${signal.getChatEnabled}")
                  println(s"Signals Id: ${signal.getId}")
                  println(s"Signals Enabled: ${signal.getEnabled}")
                }

              case exception: APIException =>
                println(s"Status: ${exception.getStatus.getValue}")
                println(s"Code: ${exception.getCode.getValue}")
                println("Details: ")
                exception.getDetails.foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"$key: $value")
                  }
                }
                println(s"Message: ${exception.getMessage}")

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

      getSignals()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
