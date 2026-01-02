package samples.users

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.users.{ActionHandler, ActionWrapper, APIException, BodyWrapper, UsersOperations, Users, Profile, Role}
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.Initializer

import scala.collection.mutable.ArrayBuffer

object CreateUsers {

  @throws[Exception]
  private def createUsers(): Unit = {
    val usersOperations = new UsersOperations()
    val request = new BodyWrapper()
    
    // Create users list
    val usersList = ArrayBuffer[Users]()
    
    // Create first user
    val user1 = new Users()
    user1.setFirstName(Option("John"))
    user1.setLastName(Option("Doe"))
    user1.setEmail(Option("john.doe@example.com"))
    user1.setStatus(Option("active"))
    
    // Set profile
    val profile = new Profile()
    profile.setId(Option(1055806000000026014L)) // Existing profile ID
    user1.setProfile(Option(profile))
    
    // Set role
    val role = new Role()
    role.setId(Option(1055806000000026008L)) // Existing role ID
    user1.setRole(Option(role))
    
    usersList += user1
    request.setUsers(usersList)
    
    val response: Option[APIResponse[ActionHandler]] = usersOperations.createUsers(request)

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
          println("No response received from CreateUsers API.")
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

      createUsers()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}