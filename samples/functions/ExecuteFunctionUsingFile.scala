package samples.functions

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api._
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.USDataCenter
import com.zoho.crm.api.functions._
import com.zoho.crm.api.util._
import scala.jdk.CollectionConverters._

object ExecuteFunctionUsingFile {

  @throws[Exception]
  def executeFunctionUsingFile(): Unit = {
    val functionName = "test_java"
    val authType = "oauth"
    val functionsOperations = new FunctionsOperations(functionName, Option(authType), null)
    val fileBodyWrapper = new FileBodyWrapper()
    val streamWrapper = new StreamWrapper("./sample.txt")
    fileBodyWrapper.setInputfile(Option(streamWrapper))
    val paramInstance = new ParameterMap()
    val param = Map(
      "1221" -> "2111221",
      "15221" -> "21113221",
      "12421" -> "211341221"
    )
    paramInstance.add(new Param("Java", classOf[Map[String, String]].getCanonicalName), param.asJava)
    val headerInstance = new HeaderMap()
    val response = functionsOperations.executeFunctionUsingFile(fileBodyWrapper, Option(paramInstance), Option(headerInstance))

    response match {
      case Some(apiResponse) =>
        println(s"Status Code: ${apiResponse.getStatusCode}")

        if (apiResponse.isExpected) {
          apiResponse.getObject match {
            case successResponse: SuccessResponse =>
              println(s"Code: ${successResponse.getCode.getValue}")
              println("Details: ")
              successResponse.getDetails().foreach { details =>
                details.foreach { case (key, value) =>
                  println(s"$key: $value")
                }
              }
              println(s"Message: ${successResponse.getMessage.getValue}")

            case exception: APIException =>
              println(s"Status: ${exception.getStatus.getValue}")
              println(s"Code: ${exception.getCode.getValue}")
              println("Details: ")
              exception.getDetails().foreach { details =>
                details.foreach { case (key, value) =>
                  println(s"$key: $value")
                }
              }
              println(s"Message: ${exception.getMessage.getValue}")

            case _ => println("Unexpected response type.")
          }
        } else {
          val responseObject = apiResponse.getModel
          val clazz = responseObject.getClass
          clazz.getDeclaredFields.foreach { field =>
            field.setAccessible(true)
            println(s"${field.getName}: ${field.get(responseObject)}")
          }
        }

      case None => println("No response received from the API.")
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

      executeFunctionUsingFile()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
