package samples.record

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.{HeaderMap, Initializer}
import com.zoho.crm.api.record.{APIException, ActionHandler, ActionResponse, ActionWrapper, BodyWrapper, Record, RecordOperations, SuccessResponse}
import com.zoho.crm.api.record.RecordOperations.UpdateRecordsHeader
import com.zoho.crm.api.dc.{DataCenter, USDataCenter}
import com.zoho.crm.api.record.Field.Leads
import com.zoho.crm.api.util.{APIResponse, Choice}

import scala.collection.mutable.ArrayBuffer

object UpdateRecords {

  @throws[Exception]
  private def updateRecords(moduleAPIName: String): Unit = {
    val recordOperations = new RecordOperations(moduleAPIName)
    val bodyWrapper = new BodyWrapper()
    val records = ArrayBuffer[Record]()
    
    // Update first record
    val record1 = new Record()
    record1.setId(Option(1055806000023297045L))
    record1.addFieldValue(new Leads().Company, "Updated Company 1")
    record1.addFieldValue(new Leads().AnnualRevenue, 150.0)
    record1.addFieldValue(new Leads().LeadSource, null)
    record1.addFieldValue(new Leads().LeadSource, new Choice[String]("Advertisement"))
   record1.addFieldValue(new Leads().LeadStatus, new Choice[String]("Contacted"))
    
    // Update second record
    val record2 = new Record()
    record2.setId(Option(3477061000005177003L))
    record2.addFieldValue(new Leads().Company, "Updated Company 2")
    record2.addFieldValue(new Leads().AnnualRevenue, 250.0)
    record2.addFieldValue(new Leads().LeadSource, new Choice[String]("Cold Call"))
   record2.addFieldValue(new Leads().LeadStatus, new Choice[String]("Qualified"))
    
    records += record1
    records += record2
    bodyWrapper.setData(records)
    
    val headerInstance = new HeaderMap()
   headerInstance.add(new UpdateRecordsHeader().XEXTERNAL, "Leads.External")

    val response: Option[APIResponse[ActionHandler]] = recordOperations.updateRecords(bodyWrapper, Option(headerInstance))

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

        case None => println("No response from the UpdateRecords API.")
      }
    }
  }

  @throws[Exception]
  def main(args: Array[String]): Unit = {
    try {
      val environment: DataCenter.Environment = USDataCenter.PRODUCTION
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
      updateRecords(moduleAPIName)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}