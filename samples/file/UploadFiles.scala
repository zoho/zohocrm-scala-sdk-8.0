package samples.file

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.{Initializer, ParameterMap}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.files.*
import com.zoho.crm.api.util.{APIResponse, StreamWrapper}

import scala.collection.mutable.ArrayBuffer

object UploadFiles {

  @throws[Exception]
  private def uploadFiles(): Unit = {
    val filePath = "./download.png"
    val filesOperations = new FilesOperations()
    val paramInstance = new ParameterMap()
    val bodyWrapper = new BodyWrapper()
    val streamWrapper = new StreamWrapper(filePath)
    var file = new ArrayBuffer[StreamWrapper]
    file+=(streamWrapper)
    bodyWrapper.setFile(file)
    val response: Option[APIResponse[ActionHandler]] = filesOperations.uploadFiles(bodyWrapper, Option(paramInstance))

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          
          if (apiResponse.isExpected) {
            val responseHandler = apiResponse.getObject

            responseHandler match {
              case actionWrapper: ActionWrapper =>
                val actionResponses = actionWrapper.getData()
                if (actionResponses != null) {
                  actionResponses.foreach {
                    case successResponse: SuccessResponse =>
                      println(s"Status: ${successResponse.getStatus().getValue}")
                      println(s"Code: ${successResponse.getCode().getValue}")
                      successResponse.getDetails().foreach { details =>
                        details.foreach { case (key, value) =>
                          println(s"$key: $value")
                        }
                      }
                      if (successResponse.getMessage().isDefined) {
                        println(s"Message: ${successResponse.getMessage()}")
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

      uploadFiles()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}