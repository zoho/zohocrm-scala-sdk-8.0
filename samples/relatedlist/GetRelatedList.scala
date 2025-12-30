package samples.relatedlist

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.relatedlists.RelatedListsOperations.GetRelatedListParam
import com.zoho.crm.api.relatedlists.{APIException, RelatedListsOperations, ResponseHandler, ResponseWrapper}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse

object GetRelatedList {

  @throws[Exception]
  private def getRelatedList(relatedListId: Long): Unit = {
    val relatedListsOperations = new RelatedListsOperations()
    val paramInstance = new ParameterMap()
    paramInstance.add(new GetRelatedListParam().module, "Leads")
    
    val response: Option[APIResponse[ResponseHandler]] = relatedListsOperations.getRelatedList(relatedListId, Option(paramInstance))

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
                val relatedLists = responseWrapper.getRelatedLists()
                if (relatedLists != null) {
                  relatedLists.foreach { relatedList =>
                    println(s"RelatedList ID: ${relatedList.getId()}")
                    
                    if (relatedList.getSequenceNumber().isDefined) {
                      println(s"RelatedList Sequence Number: ${relatedList.getSequenceNumber().get}")
                    }
                    if (relatedList.getDisplayLabel().isDefined) {
                      println(s"RelatedList Display Label: ${relatedList.getDisplayLabel().get}")
                    }
                    if (relatedList.getAPIName().isDefined) {
                      println(s"RelatedList API Name: ${relatedList.getAPIName().get}")
                    }
                    if (relatedList.getModule().isDefined) {
                      val module = relatedList.getModule().get
                      println(s"RelatedList Module - ID: ${module.getId()}")
                      if (module.getAPIName().isDefined) {
                        println(s"RelatedList Module - API Name: ${module.getAPIName().get}")
                      }
                    }
                    if (relatedList.getName().isDefined) {
                      println(s"RelatedList Name: ${relatedList.getName().get}")
                    }
                    if (relatedList.getAction().isDefined) {
                      println(s"RelatedList Action: ${relatedList.getAction().get}")
                    }
                    if (relatedList.getHref().isDefined) {
                      println(s"RelatedList Href: ${relatedList.getHref().get}")
                    }
                    if (relatedList.getType().isDefined) {
                      println(s"RelatedList Type: ${relatedList.getType().get}")
                    }
                    if (relatedList.getConnectedmodule().isDefined) {
                      val connectedModule = relatedList.getConnectedmodule().get
                      println(s"RelatedList Connected Module - Name: ${connectedModule}")
                    }
                    if (relatedList.getLinkingmodule().isDefined) {
                      val linkingModule = relatedList.getLinkingmodule().get
                      println(s"RelatedList Linking Module - Name: ${linkingModule}")
                    }
                    if (relatedList.getVisible().isDefined) {
                      println(s"RelatedList Visible: ${relatedList.getVisible().get}")
                    }
                    
                    // Display fields if available
                    val fields = relatedList.getFields()
                    if (fields != null && fields.nonEmpty) {
                      println("RelatedList Fields:")
                      fields.foreach { field =>
                        if (field.getAPIName().isDefined) {
                          println(s"  Field API Name: ${field.getAPIName().get}")
                        }
                        println("  ----------")
                      }
                    }
                    println("--------------------")
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

      val relatedListId = 1055806000000003773L
      getRelatedList(relatedListId)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}