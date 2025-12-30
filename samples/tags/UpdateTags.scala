package samples.tags

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.tags.{ActionHandler, ActionWrapper, APIException, BodyWrapper, SuccessResponse, Tag, TagsOperations}
import com.zoho.crm.api.tags.TagsOperations.UpdateTagsParam
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.{Initializer, ParameterMap}

import scala.collection.mutable.ArrayBuffer

object UpdateTags {

  @throws[Exception]
  private def updateTags(): Unit = {
    val tagsOperations = new TagsOperations()
    val request = new BodyWrapper()
    val tags = new ArrayBuffer[Tag]()

    // Update Tag 1
    val tag1 = new Tag()
    tag1.setId(Option(1055806000028713001L))
    tag1.setName(Option("Critical"))
    tag1.setColorCode(Option("#FF0000"))
    
    tags += tag1

    // Update Tag 2
    val tag2 = new Tag()
    tag2.setId(Option(34770615791025L))
    tag2.setName(Option("Warm Lead"))
    tag2.setColorCode(Option("#FFA500"))
    
    tags += tag2

    request.setTags(tags)

    val paramInstance = new ParameterMap()
    paramInstance.add(new UpdateTagsParam().module, "Leads")
    
    val response: Option[APIResponse[ActionHandler]] = tagsOperations.updateTags(
      request, 
      Option(paramInstance)
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
          println("No response received from UpdateTags API.")
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

      updateTags()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}