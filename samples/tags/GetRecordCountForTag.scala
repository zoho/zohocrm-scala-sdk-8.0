package samples.tags

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.tags.{APIException, CountResponseWrapper, TagsOperations}
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.tags.TagsOperations.GetRecordCountForTagParam
import com.zoho.crm.api.Initializer

object GetRecordCountForTag {

  @throws[Exception]
  private def getRecordCountForTag(moduleAPIName: String, tagId: Long): Unit = {
    val tagsOperations = new TagsOperations()
    val paramInstance = new ParameterMap()
    
    // Specify what to include in the count
    paramInstance.add(new GetRecordCountForTagParam().module, moduleAPIName)
    
    val response = tagsOperations.getRecordCountForTag(
      tagId,
      Option(paramInstance)
    )

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.isExpected) {
            val countWrapper = apiResponse.getObject

            countWrapper match {
              case countWrapper: CountResponseWrapper =>
                println(s"Record Count: ${countWrapper.getCount()}")

              case exception: APIException =>
                println(s"Status: ${exception.getStatus().getValue}")
                println(s"Code: ${exception.getCode().getValue}")
                exception.getDetails().foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"Details: $key -> $value")
                  }
                }
                println(s"Message: ${exception.getMessage()}")

              case _ =>
                println("Unexpected response wrapper")
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
          println("No response received from GetRecordCountForTag API.")
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

      val tagId = 1055806000028847004L      // Tag ID to get count for
      val moduleAPIName = "Leads"       // Module API name
      getRecordCountForTag(moduleAPIName, tagId)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}