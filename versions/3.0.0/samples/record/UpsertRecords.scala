package samples.record

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.{HeaderMap, Initializer}
import com.zoho.crm.api.record.{ActionHandler, ActionWrapper, APIException, BodyWrapper, Record, RecordOperations, SuccessResponse}
import com.zoho.crm.api.record.RecordOperations.UpsertRecordsHeader
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.util.{APIResponse, Choice}
import com.zoho.crm.api.record.Field.Leads

import scala.collection.mutable.ArrayBuffer

object UpsertRecords {

  @throws[Exception]
  private def upsertRecords(moduleAPIName: String): Unit = {
    val recordOperations = new RecordOperations(moduleAPIName)
    val bodyWrapper = new BodyWrapper()
    val records = ArrayBuffer[Record]()
    
    // Create first record for upsert
    val record1 = new Record()
    record1.addFieldValue(new Leads().LastName, "TestUpsert1")
    record1.addFieldValue(new Leads().FirstName, "Test")
    record1.addFieldValue(new Leads().Company, "Zoho")
    record1.addFieldValue(new Leads().Email, "testupsert1@zohotest.com")
    record1.addFieldValue(new Leads().Phone, "9876543210")
    record1.addFieldValue(new Leads().Website, "www.zohotestupsert.com")
    record1.addFieldValue(new Leads().LeadSource, new Choice("Advertisement"))
    record1.addFieldValue(new Leads().AnnualRevenue, 150.0)
    record1.addFieldValue(new Leads().LeadStatus, new Choice("Attempted to Contact"))
    
    // Create second record for upsert
    val record2 = new Record()
    record2.addFieldValue(new Leads().LastName, "TestUpsert2")
    record2.addFieldValue(new Leads().FirstName, "Test2")
    record2.addFieldValue(new Leads().Company, "Zoho")
    record2.addFieldValue(new Leads().Email, "testupsert2@zohotest.com")
    record2.addFieldValue(new Leads().Phone, "9876543211")
    record2.addFieldValue(new Leads().Website, "www.zohotestupsert2.com")
    record2.addFieldValue(new Leads().LeadSource, new Choice("Cold Call"))
    record2.addFieldValue(new Leads().AnnualRevenue, 250.0)
    record2.addFieldValue(new Leads().LeadStatus, new Choice("Contacted"))
    
    records += record1
    records += record2
    bodyWrapper.setData(records)
    
    val headerInstance = new HeaderMap()
//    headerInstance.add(new UpsertRecordsHeader().XEXTERNAL, "Leads.External")

    val response: Option[APIResponse[ActionHandler]] = recordOperations.upsertRecords(bodyWrapper, Option(headerInstance))

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

        case None => println("No response from the UpsertRecords API.")
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
      upsertRecords(moduleAPIName)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}