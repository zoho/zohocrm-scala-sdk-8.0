package samples.record

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.record.Field.Leads
import com.zoho.crm.api.record.RecordOperations.UpdateRecordUsingExternalIDHeader
import com.zoho.crm.api.record.{APIException, ActionHandler, ActionWrapper, BodyWrapper, Record, RecordOperations, SuccessResponse}
import com.zoho.crm.api.util.{APIResponse, Choice}
import com.zoho.crm.api.{HeaderMap, Initializer}

import scala.collection.mutable.ArrayBuffer

object UpdateRecordUsingExternalId {

  @throws[Exception]
  private def updateRecordUsingExternalId(moduleAPIName: String, externalFieldValue: String): Unit = {
    val recordOperations = new RecordOperations(moduleAPIName)
    val bodyWrapper = new BodyWrapper()
    val records = ArrayBuffer[Record]()
    val record = new Record()
    
    // Set field values for the external ID record update
    record.addFieldValue(new Leads().Company, "Updated External Company")
    record.addFieldValue(new Leads().AnnualRevenue, 175.0)
    record.addFieldValue(new Leads().LeadSource, new Choice("Advertisement"))
    record.addFieldValue(new Leads().LeadStatus, new Choice("Contacted"))
    record.addFieldValue(new Leads().FirstName, "UpdatedExternal")
    record.addFieldValue(new Leads().LastName, "TestLead")
    record.addFieldValue(new Leads().Email, "updatedexternal@zohotest.com")
    record.addFieldValue(new Leads().Phone, "9876543999")
    
    // Add record to the list
    records += record
    bodyWrapper.setData(records)
    
    val headerInstance = new HeaderMap()
    headerInstance.add(new UpdateRecordUsingExternalIDHeader().XEXTERNAL, "Leads.External")

    val response: Option[APIResponse[ActionHandler]] = recordOperations.updateRecordUsingExternalId(externalFieldValue, bodyWrapper, Option(headerInstance))

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
                    println(s"External Field Value: $externalFieldValue")

                  case exception: APIException =>
                    println(s"Status: ${exception.getStatus().getValue}")
                    println(s"Code: ${exception.getCode().getValue}")

                    exception.getDetails().foreach { details =>
                      details.foreach { case (key, value) =>
                        println(s"Details: $key -> $value")
                      }
                    }

                    println(s"Message: ${exception.getMessage().getValue}")

                  case _ => println("Unexpected action response type.")
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

              case _ => println("Unexpected handler type.")
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

        case None => println("No response from the UpdateRecordUsingExternalId API.")
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
      val externalFieldValue = "TestExternal123"
      updateRecordUsingExternalId(moduleAPIName, externalFieldValue)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}