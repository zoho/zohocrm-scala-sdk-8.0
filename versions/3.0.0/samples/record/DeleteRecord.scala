package samples.record

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.{HeaderMap, Initializer, ParameterMap}
import com.zoho.crm.api.record.{ActionHandler, ActionResponse, ActionWrapper, APIException, RecordOperations, SuccessResponse}
import com.zoho.crm.api.record.RecordOperations.{DeleteRecordHeader, DeleteRecordParam}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.util.APIResponse

object DeleteRecord {

  @throws[Exception]
  private def deleteRecord(moduleAPIName: String, recordId: Long): Unit = {
    val recordOperations = new RecordOperations(moduleAPIName)
    val paramInstance = new ParameterMap()
    paramInstance.add(new DeleteRecordParam().wfTrigger, true)
    
    val headerInstance = new HeaderMap()
//    headerInstance.add(new DeleteRecordHeader().XEXTERNAL, "Leads.External")

    val response: Option[APIResponse[ActionHandler]] = recordOperations.deleteRecord(recordId, Option(paramInstance), Option(headerInstance))

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

        case None => println("No response from the DeleteRecord API.")
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
      val recordId = 1055806000028812002L
      deleteRecord(moduleAPIName, recordId)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}