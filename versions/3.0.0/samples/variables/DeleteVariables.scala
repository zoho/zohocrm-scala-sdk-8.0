package samples.variables

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.variables.{ActionHandler, ActionWrapper, APIException, SuccessResponse, VariablesOperations}
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.{Initializer, ParameterMap}

object DeleteVariables {

  @throws[Exception]
  private def deleteVariables(variableIds: List[Long]): Unit = {
    val variablesOperations = new VariablesOperations()
    
    // Create parameter map with variable IDs to delete
    val paramInstance = new ParameterMap()
    val idsString = variableIds.mkString(",")
    paramInstance.add(new VariablesOperations.DeleteVariablesParam().ids, idsString)

    val response: Option[APIResponse[ActionHandler]] = variablesOperations.deleteVariables(Option(paramInstance))

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          
          if (apiResponse.isExpected) {
            val actionHandler = apiResponse.getObject

            actionHandler match {
              case actionWrapper: ActionWrapper =>
                val actionResponses = actionWrapper.getVariables()
                if (actionResponses != null) {
                  actionResponses.foreach {
                    case successResponse: com.zoho.crm.api.variables.SuccessResponse =>
                      println(s"Status: ${successResponse.getStatus().getValue}")
                      println(s"Code: ${successResponse.getCode().getValue}")

                      if (successResponse.getDetails().isDefined) {
                        val details = successResponse.getDetails().get
                        details.foreach { case (key, value) =>
                          println(s"Details: $key -> $value")
                        }
                      }

                      println(s"Message: ${successResponse.getMessage()}")

                    case exception: APIException =>
                      println(s"Status: ${exception.getStatus().getValue}")
                      println(s"Code: ${exception.getCode().getValue}")
                      exception.getDetails().foreach { details =>
                        details.foreach { case (key, value) =>
                          println(s"Details: $key -> $value")
                        }
                      }
                      println(s"Message: ${exception.getMessage()}")
                  }
                }

              case exception: APIException =>
                println("API Exception occurred:")
                println(s"Status: ${exception.getStatus().getValue}")
                println(s"Code: ${exception.getCode().getValue}")
                
                exception.getDetails().foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"Details: $key -> $value")
                  }
                }
                
                println(s"Message: ${exception.getMessage()}")

              case _ =>
                println("Unexpected action handler")
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
          println("No response received from DeleteVariables API.")
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

      // Replace with actual variable IDs you want to delete
      val variableIdsToDelete = List(
        1055806000028634001L,
        1055806000028697004L,
        1055806000028328001L
      )
      
      deleteVariables(variableIdsToDelete)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}