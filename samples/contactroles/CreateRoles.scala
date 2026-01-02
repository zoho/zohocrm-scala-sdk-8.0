package samples.contactroles

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.contactroles.{ActionHandler, ActionResponse, ActionWrapper, APIException, BodyWrapper, ContactRole, ContactRolesOperations, SuccessResponse}
import com.zoho.crm.api.dc.DataCenter.Environment
import com.zoho.crm.api.dc.INDataCenter
import com.zoho.crm.api.util.APIResponse

import scala.collection.mutable.ArrayBuffer

object CreateRoles {

  @throws[Exception]
  private def createRoles(): Unit = {
    val contactRolesOperations = new ContactRolesOperations()
    val request = new BodyWrapper()
    val contactRoles = new ArrayBuffer[ContactRole]()

    // Create first contact role
    val contactRole1 = new ContactRole()
    contactRole1.setName(Option("Senior Manager"))
    contactRole1.setSequenceNumber(Option(1))
    contactRoles.addOne(contactRole1)

    // Create second contact role
    val contactRole2 = new ContactRole()
    contactRole2.setName(Option("Assistant Manager"))
    contactRole2.setSequenceNumber(Option(2))
    contactRoles.addOne(contactRole2)

    // Create third contact role
    val contactRole3 = new ContactRole()
    contactRole3.setName(Option("Team Lead"))
    contactRole3.setSequenceNumber(Option(3))
    contactRoles.addOne(contactRole3)

    request.setContactRoles(contactRoles)

    val response: Option[APIResponse[ActionHandler]] = contactRolesOperations.createRoles(request)

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.isExpected) {
            val actionHandler = apiResponse.getObject

            actionHandler match {
              case actionWrapper: ActionWrapper =>
                val actionResponses = actionWrapper.getContactRoles()
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
                          }
                        }
                        println(s"Message: ${successResponse.getMessage().getValue}")

                      case exception: APIException =>
                        println(s"Status: ${exception.getStatus().getValue}")
                        println(s"Code: ${exception.getCode().getValue}")
                        println("Details: ")
                        exception.getDetails().foreach { details =>
                          details.foreach { case (key, value) =>
                            println(s"$key: $value")
                          }
                        }
                        println(s"Message: ${exception.getMessage().getValue}")

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

      createRoles()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}