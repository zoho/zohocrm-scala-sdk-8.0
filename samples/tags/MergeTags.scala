package samples.tags

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.tags.{APIException, ActionHandler, ActionWrapper, ConflictWrapper, MergeWrapper, SuccessResponse, TagsOperations}
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.Initializer

import scala.collection.mutable.ArrayBuffer

object MergeTags {

  @throws[Exception]
  private def mergeTags(tagId: Long, conflictId: String): Unit = {
    val tagsOperations = new TagsOperations()
    val request = new MergeWrapper()
    val mergeTag = new ConflictWrapper()
    mergeTag.setConflictId(Option(conflictId))
    request.setTags(ArrayBuffer[ConflictWrapper](mergeTag))
    val response: Option[APIResponse[ActionHandler]] = tagsOperations.mergeTags(
      tagId,
      request
    )

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.isExpected) {
            val actionHandler = apiResponse.getObject

            actionHandler match {
              case actionWrapper: ActionWrapper =>
                val actionResponses = actionWrapper.getTags()
                if (actionResponses != null) {
                  actionResponses.foreach {
                    case successResponse: SuccessResponse =>
                      println(s"Status: ${successResponse.getStatus().getValue}")
                      println(s"Code: ${successResponse.getCode().getValue}")
                      println(s"Details:")
                      successResponse.getDetails().foreach { details =>
                        details.foreach { case (key, value) =>
                          println(s"  $key -> $value")
                        }
                      }
                      println(s"Message: ${successResponse.getMessage()}")

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
                println("Unexpected action handler")
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
          println("No response received from MergeTags API.")
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

      val tagId = 1055806000028847004L  // Master tag ID to merge with
      val conflictId = "1055806000028851001"
      mergeTags(tagId, conflictId)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}