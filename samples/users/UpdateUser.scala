package samples.users

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.users.{APIException, ActionHandler, ActionWrapper, BodyWrapper, Profile, Role, Users, UsersOperations}
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.Initializer

import scala.collection.mutable.ArrayBuffer

object UpdateUser {

  @throws[Exception]
  private def updateUser(userId: Long): Unit = {
    val usersOperations = new UsersOperations()
    val request = new BodyWrapper()
    val usersList = ArrayBuffer[Users]()
    // Create first user
    val user1 = new Users()
    user1.setFirstName(Option("John"))
    user1.setLastName(Option("Doe"))

    // Set profile
    val profile = new Profile()
    profile.setId(Option(34770615791001L)) // Existing profile ID
    user1.setProfile(Option(profile))

    // Set role
    val role = new Role()
    role.setId(Option(34770615791001L)) // Existing role ID
    user1.setRole(Option(role))

    usersList += user1
    request.setUsers(usersList)
    
    val response: Option[APIResponse[ActionHandler]] = usersOperations.updateUser(userId, request)

    if (response.isDefined) {
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
          println("No response received from UpdateUser API.")
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

      updateUser(1055806000028843012L) // Replace with actual user ID
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}