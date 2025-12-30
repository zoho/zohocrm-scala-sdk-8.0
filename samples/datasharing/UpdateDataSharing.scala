package samples.datasharing

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.datasharing._
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.USDataCenter
import com.zoho.crm.api.util.Choice

import scala.collection.mutable.ArrayBuffer
import scala.jdk.CollectionConverters._

object UpdateDataSharing {

  @throws[Exception]
  def updateDataSharing(): Unit = {
    val dataSharingOperations = new DataSharingOperations()
    val request = new BodyWrapper()

    val dataSharing = new DataSharing()
    dataSharing.setShareType(new Choice[String]("private"))

    val module = new Module()
    module.setAPIName(Option("Leads"))
    module.setId(Option(34770612175L))
    dataSharing.setModule(Option(module))

    request.setDataSharing(ArrayBuffer(dataSharing))

    val response = dataSharingOperations.updateDataSharing(request)

    response match {
      case Some(apiResponse) =>
        println(s"Status Code: ${apiResponse.getStatusCode}")

        if (apiResponse.isExpected) {
          apiResponse.getObject match {
            case actionWrapper: ActionWrapper =>
              val actionResponses = actionWrapper.getDataSharing()
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
                  println(s"Message: ${successResponse.getMessage()}")

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

          }
        } else {
          val responseObject = apiResponse.getModel
          val clazz = responseObject.getClass
          clazz.getDeclaredFields.foreach { field =>
            field.setAccessible(true)
            println(s"${field.getName}: ${field.get(responseObject)}")
          }
        }
    }
  }

  @throws[Exception]
  def main(args: Array[String]): Unit = {
    try {
      val environment: Environment = USDataCenter.PRODUCTION
      val token: Token = new OAuthToken.Builder()
        .clientID("Client_Id")
        .clientSecret("Client_Secret")
        .refreshToken("Refresh_Token")
        .build()

      new Initializer.Builder()
        .environment(environment)
        .token(token)
        .initialize()

      updateDataSharing()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
