package samples.record

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.{Initializer, ParameterMap}
import com.zoho.crm.api.record.{APIException, CountHandler, CountWrapper, RecordOperations}
import com.zoho.crm.api.record.RecordOperations.RecordCountParam
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.util.APIResponse

object RecordCount {

  @throws[Exception]
  private def recordCount(moduleAPIName: String): Unit = {
    val recordOperations = new RecordOperations(moduleAPIName)
    val paramInstance = new ParameterMap()
    paramInstance.add(new RecordCountParam().criteria, "((Company:starts_with:Zoho)and(Lead_Source:equals:Advertisement))")
    paramInstance.add(new RecordCountParam().email, "test@zoho.com")
    paramInstance.add(new RecordCountParam().phone, "9876543210")
    paramInstance.add(new RecordCountParam().word, "Zoho")

    val response: Option[APIResponse[CountHandler]] = recordOperations.recordCount(Option(paramInstance))

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.isExpected) {
            val countHandler = apiResponse.getObject

            countHandler match {
              case countWrapper: CountWrapper =>
                if (countWrapper.getCount() != null && countWrapper.getCount().isDefined) {
                  println(s"Record Count: ${countWrapper.getCount().get}")
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

              case _ => println("Unexpected count handler type.")
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

        case None => println("No response from the RecordCount API.")
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

      val moduleAPIName = "Leads"
      recordCount(moduleAPIName)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}