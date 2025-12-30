package samples.users

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.users.{ActionHandler, ActionWrapper, APIException, BodyWrapper, UsersOperations, Users}
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.Initializer

import scala.collection.mutable.ArrayBuffer

object UpdateUsers {

  @throws[Exception]
  private def updateUsers(): Unit = {
    val usersOperations = new UsersOperations()
    val request = new BodyWrapper()
    
    // Create users list with updates
    val usersList = ArrayBuffer[Users]()
    
    // Update first user
    val user1 = new Users()
    user1.setId(Option(1055806000028843012L)) // Existing user ID
    user1.setFirstName(Option("John Updated"))
    user1.setLastName(Option("Doe Updated"))
    user1.setEmail(Option("john.doe.updated@example.com"))
    user1.setPhone(Option("555-999-1111"))
    user1.setWebsite(Option("www.updated-example.com"))
    
    usersList += user1
    request.setUsers(usersList)
    
    val response: Option[APIResponse[ActionHandler]] = usersOperations.updateUsers(request)

    if (response != null) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          if (apiResponse.isExpected) {
            val actionHandler = apiResponse.getObject

            actionHandler match {
              case actionWrapper: ActionWrapper =>
                val actionResponses = actionWrapper.getUsers()
                if (actionResponses != null) {
                  actionResponses.foreach {
                    case successResponse: com.zoho.crm.api.users.SuccessResponse =>
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
          println("No response received from UpdateUsers API.")
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

      updateUsers()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}