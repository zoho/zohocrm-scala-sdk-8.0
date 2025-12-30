package samples.tags

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.tags.{APIException, ResponseHandler, ResponseWrapper, TagsOperations}
import com.zoho.crm.api.tags.TagsOperations.GetTagsParam
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.{Initializer, ParameterMap}

object GetTags {

  @throws[Exception]
  private def getTags(): Unit = {
    val tagsOperations = new TagsOperations()
    
    val paramInstance = new ParameterMap()
    paramInstance.add(new GetTagsParam().module, "Leads")
    val response: Option[APIResponse[ResponseHandler]] = tagsOperations.getTags(
      Option(paramInstance)
    )

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          
          if (List(204, 304).contains(apiResponse.getStatusCode)) {
            println(if (apiResponse.getStatusCode == 204) "No Content" else "Not Modified")
            return
          }

          if (apiResponse.isExpected) {
            val responseHandler = apiResponse.getObject

            responseHandler match {
              case responseWrapper: ResponseWrapper =>
                val tags = responseWrapper.getTags()
                if (tags != null) {
                  println(s"Found ${tags.size} tags:")
                  
                  tags.foreach { tag =>
                    println(s"Tag ID: ${tag.getId()}")
                    
                    if (tag.getName().isDefined) {
                      println(s"Tag Name: ${tag.getName().get}")
                    }
                    if (tag.getColorCode().isDefined) {
                      println(s"Tag Color Code: ${tag.getColorCode().get}")
                    }
                    if (tag.getCreatedTime().isDefined) {
                      println(s"Tag Created Time: ${tag.getCreatedTime().get}")
                    }
                    if (tag.getModifiedTime().isDefined) {
                      println(s"Tag Modified Time: ${tag.getModifiedTime().get}")
                    }
                    if (tag.getCreatedBy().isDefined) {
                      val createdBy = tag.getCreatedBy().get
                      println(s"Created By - ID: ${createdBy.getId()}")
                      if (createdBy.getName().isDefined) {
                        println(s"Created By - Name: ${createdBy.getName().get}")
                      }
                    }
                    
                    if (tag.getModifiedBy().isDefined) {
                      val modifiedBy = tag.getModifiedBy().get
                      println(s"Modified By - ID: ${modifiedBy.getId()}")
                      if (modifiedBy.getName().isDefined) {
                        println(s"Modified By - Name: ${modifiedBy.getName().get}")
                      }
                    }
                    
                    println("--------------------")
                  }
                } else {
                  println("No tags found.")
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
          println("No response received from GetTags API.")
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

      getTags()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}