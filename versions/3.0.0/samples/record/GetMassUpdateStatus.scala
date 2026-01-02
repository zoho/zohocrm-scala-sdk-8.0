package samples.record

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.record.Field.Leads
import com.zoho.crm.api.record.RecordOperations.{CreateRecordsHeader, GetMassUpdateStatusParam}
import com.zoho.crm.api.record.{APIException, MassUpdate, MassUpdateActionHandler, MassUpdateActionWrapper, MassUpdateBodyWrapper, MassUpdateResponseHandler, MassUpdateResponseWrapper, MassUpdateSuccessResponse, Record, RecordOperations}
import com.zoho.crm.api.util.{APIResponse, Choice}
import com.zoho.crm.api.{Initializer, ParameterMap}

import scala.collection.mutable.ArrayBuffer

object GetMassUpdateStatus {

  @throws[Exception]
  private def getMassUpdateStatus(moduleAPIName: String, jobId: String): Unit = {
    val recordOperations = new RecordOperations(moduleAPIName)
    val paramInstance = new ParameterMap();
    paramInstance.add(new GetMassUpdateStatusParam().jobId, jobId)
    val response: Option[APIResponse[MassUpdateResponseHandler]] = recordOperations.getMassUpdateStatus(Option(paramInstance))

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          if (apiResponse.getStatusCode == 204) {
            println("No Content")
            return
          }
          if (apiResponse.isExpected) {
            val massUpdateResponseHandler = apiResponse.getObject
            massUpdateResponseHandler match {
              case massUpdateResponseWrapper: MassUpdateResponseWrapper => //Get the received MassUpdateResponseWrapper instance
                //Get the list of obtained MassUpdateResponse instances
                val massUpdateResponses = massUpdateResponseWrapper.getData()
                for (massUpdateResponse <- massUpdateResponses) {
                  massUpdateResponse match {
                    case massUpdate: MassUpdate => //Get the received MassUpdate instance
                      println("MassUpdate Status: " + massUpdate.getStatus().getValue)
                      println("MassUpdate FailedCount: " + massUpdate.getFailedCount().toString)
                      println("MassUpdate UpdatedCount: " + massUpdate.getUpdatedCount().toString)
                      println("MassUpdate NotUpdatedCount: " + massUpdate.getNotUpdatedCount())
                      println("MassUpdate TotalCount: " + massUpdate.getTotalCount().toString)
                    case exception: APIException =>
                      println("Status: " + exception.getStatus().getValue)
                      println("Code: " + exception.getCode().getValue)
                      println("Details: ")
                      exception.getDetails().foreach { details =>
                        details.foreach { case (key, value) =>
                          println(s"$key: $value")
                        }
                      }
                      println("Message: " + exception.getMessage().getValue)
                    case _ =>
                  }
                }
              case exception: APIException =>
                println("Status: " + exception.getStatus().getValue)
                println("Code: " + exception.getCode().getValue)
                println("Details: ")
                exception.getDetails().foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"$key: $value")
                  }
                }
                println("Message: " + exception.getMessage().getValue)
              case _ =>
            }
          }
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
      val jobId = ""
      getMassUpdateStatus(moduleAPIName, jobId)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}