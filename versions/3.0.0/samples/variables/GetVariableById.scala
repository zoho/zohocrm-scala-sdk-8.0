package samples.variables

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.variables.{APIException, ResponseHandler, ResponseWrapper, VariablesOperations}
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.{Initializer, ParameterMap}

object GetVariableById {

  @throws[Exception]
  private def getVariableById(variableId: Long): Unit = {
    val variablesOperations = new VariablesOperations()
    
    // Create parameter map for optional filtering
    val paramInstance = new ParameterMap()
    paramInstance.add(new VariablesOperations.GetVariableByIDParam().group, "General")
    
    val response: Option[APIResponse[ResponseHandler]] = variablesOperations.getVariableById(variableId, Option(paramInstance))

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          
          if (List(204, 304).contains(apiResponse.getStatusCode)) {
            println(if (apiResponse.getStatusCode == 204) "No Content" else "Not Modified")
            return
          }

          if (apiResponse.isExpected) {
            val responseHandler = apiResponse.getObject

            responseHandler match {
              case responseWrapper: ResponseWrapper =>
                val variables = responseWrapper.getVariables()
                if (variables != null && variables.nonEmpty) {
                  variables.foreach { variable =>
                    if (variable.getId() != null) {
                      println(s"Variable ID: ${variable.getId()}")
                    }

                    if (variable.getName() != null) {
                      println(s"Display Name: ${variable.getName()}")
                    }

                    if (variable.getAPIName() != null) {
                      println(s"API Name: ${variable.getAPIName()}")
                    }

                    if (variable.getValue() != null) {
                      println(s"Current Value: ${variable.getValue()}")
                    }

                    if (variable.getDescription() != null) {
                      println(s"Description: ${variable.getDescription()}")
                    }

                    if (variable.getType() != null) {
                      println(s"Data Type: ${variable.getType()}")
                    }

                    // Variable group information
                    if (variable.getVariableGroup() != null) {
                      val variableGroup = variable.getVariableGroup().get
                      println("\nVariable Group Information:")

                      if (variableGroup.getId() != null) {
                        println(s"  Group ID: ${variableGroup.getId()}")
                      }
                      if (variableGroup.getAPIName() != null) {
                        println(s"  Group API Name: ${variableGroup.getAPIName()}")
                      }
                    }
                  }
                }
              case exception: APIException =>
                println(s"Status: ${exception.getStatus().getValue}")
                println(s"Code: ${exception.getCode().getValue}")
                exception.getDetails().foreach { details =>
                  details.foreach { case (key, value) =>
                    println(s"Details: $key -> $value")
                  }
                }
                println(s"Message: ${exception.getMessage()}")

              case _ =>
                println("Unexpected response handler")
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
          println("No response received from GetVariableById API.")
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

      // Replace with actual variable ID
      val variableId: Long = 1055806000020209025L
      getVariableById(variableId)
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}