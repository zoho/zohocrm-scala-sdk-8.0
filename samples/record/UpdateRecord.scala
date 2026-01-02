package samples.record

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.{HeaderMap, Initializer}
import com.zoho.crm.api.record.{APIException, ActionHandler, ActionResponse, ActionWrapper, BodyWrapper, Record, RecordOperations, SuccessResponse}
import com.zoho.crm.api.record.RecordOperations.UpdateRecordHeader
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.record.Field.Leads
import com.zoho.crm.api.util.{APIResponse, Choice}

import scala.collection.mutable.ArrayBuffer

object UpdateRecord {

  @throws[Exception]
  private def updateRecord(moduleAPIName: String, recordId: Long): Unit = {
    val recordOperations = new RecordOperations(moduleAPIName)
    val bodyWrapper = new BodyWrapper()
    val records = ArrayBuffer[Record]()
    val record = new Record()
    
    // Set field values
    record.addFieldValue(new Leads().LastName, "KKRNP")
    record.addFieldValue(new Leads().AnnualRevenue, 100.0)
    record.addFieldValue(new Leads().LeadSource, new Choice("Advertisement"))
    
    // Add record to the list
    records += record
    bodyWrapper.setData(records)
    
    val headerInstance = new HeaderMap()
//    headerInstance.add(new UpdateRecordHeader().XEXTERNAL, "Leads.External")

    val response: Option[APIResponse[ActionHandler]] = recordOperations.updateRecord(recordId, bodyWrapper, Option(headerInstance))

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

        case None => println("No response from the UpdateRecord API.")
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
      val recordId = 1055806000023297045L
      updateRecord(moduleAPIName, recordId)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}