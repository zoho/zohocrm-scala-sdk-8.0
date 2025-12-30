package samples.variablegroups

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.variablegroups.{APIException, ResponseHandler, ResponseWrapper, VariableGroupsOperations}
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.Initializer

object GetVariableGroups {

  @throws[Exception]
  private def getVariableGroups(): Unit = {
    val variableGroupsOperations = new VariableGroupsOperations()
    
    val response: Option[APIResponse[ResponseHandler]] = variableGroupsOperations.getVariableGroups()

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
                val variableGroups = responseWrapper.getVariableGroups()
                if (variableGroups != null && variableGroups.nonEmpty) {
                  println(s"Found ${variableGroups.size} variable groups:")
                  println("=" * 60)
                  
                  variableGroups.foreach { variableGroup =>
                    println("Variable Group Details:")
                    
                    // Basic variable group information
                    if (variableGroup.getId() != null) {
                      println(s"Variable Group ID: ${variableGroup.getId()}")
                    }
                    
                    if (variableGroup.getName() != null) {
                      println(s"Name: ${variableGroup.getName()}")
                    }
                    
                    if (variableGroup.getAPIName() != null) {
                      println(s"API Name: ${variableGroup.getAPIName()}")
                    }
                    
                    if (variableGroup.getDescription() != null) {
                      println(s"Description: ${variableGroup.getDescription()}")
                    }
                    
                    if (variableGroup.getDisplayLabel() != null) {
                      println(s"Display Label: ${variableGroup.getDisplayLabel()}")
                    }
                    println("-" * 50)
                  }
                  
                  println(s"\nTotal Variable Groups: ${variableGroups.size}")
                } else {
                  println("No variable groups found.")
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
          println("No response received from GetVariableGroups API.")
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

      getVariableGroups()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}