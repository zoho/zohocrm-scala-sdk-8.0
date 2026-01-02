package samples.variables

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.variables.{APIException, ActionHandler, ActionWrapper, BodyWrapper, SuccessResponse, Variable, VariablesOperations}
import com.zoho.crm.api.variables.VariableGroup
import com.zoho.crm.api.util.{APIResponse, Choice}
import com.zoho.crm.api.{Initializer, ParameterMap}

import java.util
import scala.collection.mutable.ArrayBuffer

object UpdateVariableById {

  @throws[Exception]
  private def updateVariableById(variableId: Long): Unit = {
    val variablesOperations = new VariablesOperations()
    val bodyWrapper = new BodyWrapper()
    
    // Create variables list with updated information
    val variablesList = new ArrayBuffer[Variable]()
    
    val variable = new Variable()
    variable.setName(Option("Updated Variable Name"))
    variable.setValue(Option("Updated Variable Value"))
    variable.setDescription(Option("This variable has been updated via API"))
    
    variablesList.addOne(variable)
    bodyWrapper.setVariables(variablesList)
    
    // Create parameter map for optional filtering
    val paramInstance = new ParameterMap()
    paramInstance.add(new VariablesOperations.UpdateVariableByIDParam().group, "General")

    val response: Option[APIResponse[ActionHandler]] = variablesOperations.updateVariableById(variableId, bodyWrapper, Option(paramInstance))

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
          println("No response received from UpdateVariableById API.")
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

      // Replace with actual variable ID you want to update
      val variableId: Long = 1055806000018935004L
      updateVariableById(variableId)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}