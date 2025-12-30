package samples.dealcontactroles

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.ParameterMap
import com.zoho.crm.api.dealcontactroles.DealContactRolesOperations.DeleteAssociatedContactRolesParam
import com.zoho.crm.api.dealcontactroles.{ActionHandler, ActionResponse, ActionWrapper, APIException, DealContactRolesOperations, SuccessResponse}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse

object DeleteAssociatedContactRoles {

  @throws[Exception]
  private def deleteAssociatedContactRoles(): Unit = {
    val dealId = 1055806000028564012L // Replace with actual deal ID
    val dealContactRolesOperations = new DealContactRolesOperations()
    val paramInstance = new ParameterMap()
    // Add contact IDs to delete
    paramInstance.add(new DeleteAssociatedContactRolesParam().ids, "1055806000028723005,1055806000000661002,1055806000000661003")
    val response: Option[APIResponse[ActionHandler]] = dealContactRolesOperations.deleteAssociatedContactRoles(dealId, Option(paramInstance))
    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.isExpected) {
            val actionHandler = apiResponse.getObject

            actionHandler match {
              case actionWrapper: ActionWrapper =>
                val actionResponses = actionWrapper.getData()
                if (actionResponses != null) {
                  actionResponses.zipWithIndex.foreach { case (actionResponse, index) =>
                    actionResponse match {
                      case successResponse: SuccessResponse =>
                        println(s"Status: ${successResponse.getStatus().getValue}")
                        println(s"Code: ${successResponse.getCode().getValue}")
                        println("Details: ")
                        successResponse.getDetails().foreach { details =>
                          details.foreach { case (key, value) =>
                            println(s"$key: $value")
                            if (key == "id") {
                              println(s"Contact role relationship deleted successfully. Contact ID: $value")
                            }
                          }
                        }
                        println(s"Message: ${successResponse.getMessage()}")

                      case exception: APIException =>
                        println(s"Status: ${exception.getStatus().getValue}")
                        println(s"Code: ${exception.getCode().getValue}")
                        println("Details: ")
                        exception.getDetails().foreach { details =>
                          details.foreach { case (key, value) =>
                            println(s"$key: $value")
                          }
                        }
                        println(s"Message: ${exception.getMessage()}")

                      case _ =>
                        println("Unexpected action response")
                    }
                    println("--------------------")
                  }
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
          println("No response received")
      }
    }
  }

  @throws[Exception]
  def main(args: Array[String]): Unit = {
    try {
      val environment: Environment = INDataCenter.PRODUCTION
      val token: Token = new OAuthToken.Builder()
        .clientID("client_id")
        .clientSecret("client_secret")
        .grantToken("grant_token")
        .build()
      new Initializer.Builder()
        .environment(environment)
        .token(token)
        .initialize()

      deleteAssociatedContactRoles()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}