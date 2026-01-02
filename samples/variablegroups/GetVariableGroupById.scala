package samples.variablegroups

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.variablegroups.{APIException, ResponseHandler, ResponseWrapper, VariableGroupsOperations}
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.Initializer

object GetVariableGroupById {

  @throws[Exception]
  private def getVariableGroupById(variableGroupId: String): Unit = {
    val variableGroupsOperations = new VariableGroupsOperations()
    
    val response: Option[APIResponse[ResponseHandler]] = variableGroupsOperations.getVariableGroupById(variableGroupId)

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")
          
          apiResponse.getStatusCode match {
            case 204 =>
              println("No Content - Variable group not found")
            case 304 =>
              println("Not Modified")
            case _ =>
              if (apiResponse.isExpected) {
                val responseHandler = apiResponse.getObject

                responseHandler match {
                  case responseWrapper: ResponseWrapper =>
                    val variableGroups = responseWrapper.getVariableGroups()
                    if (variableGroups != null && variableGroups.nonEmpty) {
                      val variableGroup = variableGroups.head
                      
                      println(s"Variable Group Details for ID: $variableGroupId")
                      println("=" * 60)
                      
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
                    } else {
                      println(s"No variable group found with ID: $variableGroupId")
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
          }

        case None =>
          println("No response received from GetVariableGroupById API.")
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

      getVariableGroupById("1055806000023802008") // Replace with actual variable group ID
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}