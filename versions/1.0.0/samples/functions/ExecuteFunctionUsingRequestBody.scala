package samples.functions

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api._
import com.zoho.crm.api.dc.USDataCenter
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.functions._
import com.zoho.crm.api.util.{APIResponse, Model}

import scala.collection.mutable
import scala.jdk.CollectionConverters._

object ExecuteFunctionUsingRequestBody {

  @throws[Exception]
  def executeFunctionUsingRequestBody(): Unit = {
    val functionName = "get_record_lead"
    val authType = "oauth"
    val arg = mutable.HashMap(
      "12223322" -> "iuubnf"
    ).asInstanceOf[Any]
    val arguments1 = mutable.HashMap("zoho" -> arg)
    val functionsOperations = new FunctionsOperations(functionName, Option(authType), Option(arguments1))
    val bodyWrapper = new BodyWrapper()
    val requestBody = mutable.HashMap(
      "name" -> "JavaScript".asInstanceOf[Any],
      "version" -> "4.0.0",
      "v2.1" -> Map("name" -> "JAVASCRIPT-2.1", "version" -> "1.0.0")
    )
    bodyWrapper.setBody(Option(requestBody))
    val paramInstance = new ParameterMap()
    val param = Map(
      "1221" -> "2111221",
      "15221" -> "21113221",
      "12421" -> "211341221"
    )
    paramInstance.add(new Param("Java", classOf[Map[String, String]].getCanonicalName), param.asJava)
    val headerInstance = new HeaderMap()
    val response = functionsOperations.executeFunctionUsingRequestBody(bodyWrapper, Option(paramInstance), Option(headerInstance))
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

      executeFunctionUsingRequestBody()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
