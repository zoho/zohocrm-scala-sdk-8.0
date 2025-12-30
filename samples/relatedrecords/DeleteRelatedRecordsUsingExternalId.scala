package samples.relatedrecords

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.relatedrecords.RelatedRecordsOperations.{DeleteRelatedRecordsUsingExternalIDHeader, DeleteRelatedRecordsUsingExternalIDParam}
import com.zoho.crm.api.relatedrecords.{APIException, ActionHandler, ActionWrapper, RelatedRecordsOperations, SuccessResponse}
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.{HeaderMap, Initializer, ParameterMap}

import scala.collection.mutable.ArrayBuffer

object DeleteRelatedRecordsUsingExternalId {

  @throws[Exception]
  private def deleteRelatedRecordsUsingExternalId(moduleAPIName: String, externalValue: String, relatedListAPIName: String): Unit = {
    val relatedRecordsOperations = new RelatedRecordsOperations(relatedListAPIName, moduleAPIName)
    
    val paramInstance = new ParameterMap()
    // External IDs of related records to delete
    val externalIdsToDelete = ArrayBuffer("ext_product_123", "ext_product_124")
    paramInstance.add(new DeleteRelatedRecordsUsingExternalIDParam().ids, externalIdsToDelete.mkString(","))
    val xExternal = "Leads.External,Products.Products_External"
    val headerInstance = new HeaderMap()
    headerInstance.add(new DeleteRelatedRecordsUsingExternalIDHeader().XEXTERNAL, xExternal)
    val response: Option[APIResponse[ActionHandler]] = relatedRecordsOperations.deleteRelatedRecordsUsingExternalId(
      externalValue, 
      Option(paramInstance),
      Option(headerInstance)
    )

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.isExpected) {
            val actionHandler = apiResponse.getObject

            actionHandler match {
              case actionWrapper: ActionWrapper =>
                val actionResponses = actionWrapper.getData()
                actionResponses.foreach {
                  case successResponse: SuccessResponse =>
                    println(s"Status: ${successResponse.getStatus().getValue}")
                    println(s"Code: ${successResponse.getCode().getValue}")

                    successResponse.getDetails().foreach { details =>
                      details.foreach { case (key, value) =>
                        println(s"Details: $key -> $value")
                      }
                    }

                    println(s"Message: ${successResponse.getMessage().getValue}")

                  case exception: APIException =>
                    println(s"Status: ${exception.getStatus().getValue}")
                    println(s"Code: ${exception.getCode().getValue}")

                    exception.getDetails().foreach { details =>
                      details.foreach { case (key, value) =>
                        println(s"Details: $key -> $value")
                      }
                    }

                    println(s"Message: ${exception.getMessage().getValue}")

                  case _ => 
                    println("Unexpected action response type.")
                }

              case exception: APIException =>
                println(s"Status: ${exception.getStatus().getValue}")
                println(s"Code: ${exception.getCode().getValue}")
                
                exception.getDetails().foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"Details: $key -> $value")
                  }
                }
                
                println(s"Message: ${exception.getMessage().getValue}")

              case _ => 
                println("Unexpected handler type.")
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

        case None => 
          println("No response received from DeleteRelatedRecordsUsingExternalId API.")
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
      val externalValue = "ext_lead_123"  // External ID of the account record
      val relatedListAPIName = "Products"
      
      deleteRelatedRecordsUsingExternalId(moduleAPIName, externalValue, relatedListAPIName)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}