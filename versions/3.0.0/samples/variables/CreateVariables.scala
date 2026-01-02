package samples.variables

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.variables.{APIException, ActionHandler, ActionWrapper, BodyWrapper, SuccessResponse, Variable, VariablesOperations}
import com.zoho.crm.api.variables.VariableGroup
import com.zoho.crm.api.util.{APIResponse, Choice}
import com.zoho.crm.api.Initializer

import java.util
import scala.collection.mutable.ArrayBuffer

object CreateVariables {

  @throws[Exception]
  private def createVariables(): Unit = {
    val variablesOperations = new VariablesOperations()
    val bodyWrapper = new BodyWrapper()
    
    // Create variables list
    val variablesList = new ArrayBuffer[Variable]()
    
    // Create first variable
    val variable1 = new Variable()
    variable1.setName(Option("Test Variable 1"))
    variable1.setAPIName(Option("Test_Variable_1"))
    variable1.setValue(Option("Sample Value 1"))
    variable1.setDescription(Option("This is a test variable created via API"))
    variable1.setType(new Choice("text"))
    
    // Set variable group (optional)
    val variableGroup1 = new VariableGroup()
    variableGroup1.setId(Option(1055806000003089001L)) // Replace with actual variable group ID
    variable1.setVariableGroup(Option(variableGroup1))
    
    variablesList.addOne(variable1)
    
    // Create second variable
    val variable2 = new Variable()
    variable2.setName(Option("Test Variable 2"))
    variable2.setAPIName(Option("Test_Variable_2"))
    variable2.setValue(Option("Sample Value 2"))
    variable2.setDescription(Option("Another test variable created via API"))
    variable2.setType(new Choice("text"))
    
    // Set variable group (optional)
    val variableGroup2 = new VariableGroup()
    variableGroup2.setId(Option(1055806000003089001L)) // Replace with actual variable group ID
    variable2.setVariableGroup(Option(variableGroup2))
    
    variablesList.addOne(variable2)
    
    bodyWrapper.setVariables(variablesList)

    val response: Option[APIResponse[ActionHandler]] = variablesOperations.createVariables(bodyWrapper)

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
          println("No response received from CreateVariables API.")
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

      createVariables()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}