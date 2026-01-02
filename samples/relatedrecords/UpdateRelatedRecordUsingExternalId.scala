package samples.relatedrecords

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.record.Record
import com.zoho.crm.api.relatedrecords.RelatedRecordsOperations.UpdateRelatedRecordUsingExternalIDHeader
import com.zoho.crm.api.relatedrecords.{ActionHandler, ActionWrapper, APIException, BodyWrapper, RelatedRecordsOperations, SuccessResponse}
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.{HeaderMap, Initializer}

import scala.collection.mutable.ArrayBuffer

object UpdateRelatedRecordUsingExternalId {

  @throws[Exception]
  private def updateRelatedRecordUsingExternalId(moduleAPIName: String, externalValue: String, relatedListAPIName: String, externalFieldValue: String): Unit = {
    val relatedRecordsOperations = new RelatedRecordsOperations(relatedListAPIName, moduleAPIName)
    val bodyWrapper = new BodyWrapper()
    val records = ArrayBuffer[Record]()
    
    // Create updated record data using external IDs
    val record = new Record()
    record.addKeyValue("list_price", 50.56)
    
    records += record
    bodyWrapper.setData(records)
    
    val headerInstance = new HeaderMap()
    val xExternal = "Leads.External,Products.Products_External"
    headerInstance.add(new UpdateRelatedRecordUsingExternalIDHeader().XEXTERNAL, xExternal)

    val response: Option[APIResponse[ActionHandler]] = relatedRecordsOperations.updateRelatedRecordUsingExternalId(
      externalFieldValue, 
      externalValue, 
      bodyWrapper, 
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
          println("No response received from UpdateRelatedRecordUsingExternalId API.")
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
      val externalValue = "34770615177002"       // External ID of the account record
      val relatedListAPIName = "Products"
      val externalFieldValue = "34770614994115"  // External ID of the contact record to update
      
      updateRelatedRecordUsingExternalId(moduleAPIName, externalValue, relatedListAPIName, externalFieldValue)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}