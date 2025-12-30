package samples.tags

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.{Initializer, ParameterMap}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.tags.*
import com.zoho.crm.api.util.APIResponse

import scala.collection.mutable.ArrayBuffer

object AddTagsToMultipleRecords {

  @throws[Exception]
  private def addTagsToMultipleRecords(moduleAPIName: String): Unit = {
    val tagsOperations = new TagsOperations()
    val request = new NewTagRequestWrapper()
    val tags = new ArrayBuffer[Tag]()
    val tag1 = new Tag()
    tag1.setName(Option("Tag Name"))
    tags.addOne(tag1)
    request.setTags(tags)
    request.setIds(ArrayBuffer[Long](1055806000028754070L, 1055806000028754070L))

    val paramInstance = new ParameterMap()
    val response: Option[APIResponse[RecordActionHandler]] = tagsOperations.addTagsToMultipleRecords(
      moduleAPIName,
      request,
      Option(paramInstance)
    )

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.isExpected) {
            val recordActionHandler = apiResponse.getObject

            recordActionHandler match {
              case recordActionWrapper: RecordActionWrapper =>
                val recordActionResponses = recordActionWrapper.getData()
                if (recordActionResponses != null) {
                  recordActionResponses.foreach {
                    case recordSuccessResponse: RecordSuccessResponse =>
                      println(s"Status: ${recordSuccessResponse.getStatus().getValue}")
                      println(s"Code: ${recordSuccessResponse.getCode().getValue}")

                      if (recordSuccessResponse.getDetails().isDefined) {
                        val details = recordSuccessResponse.getDetails().get
                        details.foreach { case (key, value) =>
                          println(s"Details: $key -> $value")
                        }
                      }

                      println(s"Message: ${recordSuccessResponse.getMessage()}")

                    case exception: APIException =>
                      println(s"Status: ${exception.getStatus().getValue}")
                      println(s"Code: ${exception.getCode().getValue}")
                      exception.getDetails().foreach { details =>
                        details.foreach { case (key, value) =>
                          println(s"Details: $key -> $value")
                        }
                      }
                      println(s"Message: ${exception.getMessage()}")
                  }
                }

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
                println("Unexpected record action handler")
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
          println("No response received from AddTagsToMultipleRecords API.")
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
      addTagsToMultipleRecords(moduleAPIName)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}