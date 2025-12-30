package samples.record

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.record.Field.Leads
import com.zoho.crm.api.record.RecordOperations.CreateRecordsHeader
import com.zoho.crm.api.record.{APIException, MassUpdateActionHandler, MassUpdateActionWrapper, MassUpdateBodyWrapper, Record, RecordOperations, MassUpdateSuccessResponse}
import com.zoho.crm.api.util.{APIResponse, Choice}
import com.zoho.crm.api.Initializer

import scala.collection.mutable.ArrayBuffer

object MassUpdateRecords {

  @throws[Exception]
  private def massUpdateRecords(moduleAPIName: String): Unit = {
    val recordOperations = new RecordOperations(moduleAPIName)
    val bodyWrapper = new MassUpdateBodyWrapper()
    val records = ArrayBuffer[Record]()

    // Create first record
    val record1 = new Record()
    record1.addKeyValue("City", "Value");
    records += record1
    bodyWrapper.setData(records)
//    bodyWrapper.setIds()
    val response: Option[APIResponse[MassUpdateActionHandler]] = recordOperations.massUpdateRecords(bodyWrapper)

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.isExpected) {
            val actionHandler = apiResponse.getObject

            actionHandler match {
              case actionWrapper: MassUpdateActionWrapper =>
                val actionResponses = actionWrapper.getData()
                actionResponses.foreach {
                  case successResponse: MassUpdateSuccessResponse =>
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

        case None => println("No response from the CreateRecords API.")
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
      massUpdateRecords(moduleAPIName)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}