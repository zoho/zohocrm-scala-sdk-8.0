package samples.users

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.users.{APIException, ResponseHandler, ResponseWrapper, UsersOperations}
import com.zoho.crm.api.users.UsersOperations.{GetUsersHeader, GetUsersParam}
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.{HeaderMap, Initializer, ParameterMap}

import java.time.OffsetDateTime

object GetUsers {

  @throws[Exception]
  private def getUsers(): Unit = {
    val usersOperations = new UsersOperations()
    val paramMap = new ParameterMap()
    val headerMap = new HeaderMap()
    
    // Add optional parameters
    paramMap.add(new GetUsersParam().type1, "ActiveUsers")
    paramMap.add(new GetUsersParam().page, 1)
    paramMap.add(new GetUsersParam().perPage, 20)
     paramMap.add(new GetUsersParam().ids, "34770615791001,34770615791002")
    
    // Add optional headers
     headerMap.add(new GetUsersHeader().IfModifiedSince, OffsetDateTime.now().minusDays(1))
    
    val response: Option[APIResponse[ResponseHandler]] = usersOperations.getUsers(Some(paramMap), Some(headerMap))

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
                val users = responseWrapper.getUsers()
                if (users != null) {
                  println(s"Found ${users.size} users:")
                  
                  users.foreach { user =>
                    println(s"User ID: ${user.getId()}")
                    
                    if (user.getFirstName().isDefined) {
                      println(s"First Name: ${user.getFirstName().get}")
                    }
                    
                    if (user.getLastName().isDefined) {
                      println(s"Last Name: ${user.getLastName().get}")
                    }
                    
                    if (user.getEmail().isDefined) {
                      println(s"Email: ${user.getEmail().get}")
                    }
                    
                    if (user.getStatus().isDefined) {
                      println(s"Status: ${user.getStatus().get}")
                    }
                    
                    if (user.getProfile().isDefined) {
                      val profile = user.getProfile().get
                      println(s"Profile - ID: ${profile.getId()}")
                      if (profile.getName().isDefined) {
                        println(s"Profile - Name: ${profile.getName().get}")
                      }
                    }
                    
                    if (user.getRole().isDefined) {
                      val role = user.getRole().get
                      println(s"Role - ID: ${role.getId()}")
                      if (role.getName().isDefined) {
                        println(s"Role - Name: ${role.getName().get}")
                      }
                    }
                    
                    if (user.getCreatedTime().isDefined) {
                      println(s"Created Time: ${user.getCreatedTime().get}")
                    }
                    
                    if (user.getModifiedTime().isDefined) {
                      println(s"Modified Time: ${user.getModifiedTime().get}")
                    }
                    
                    if (user.getCreatedBy().isDefined) {
                      val createdBy = user.getCreatedBy().get
                      println(s"Created By - ID: ${createdBy.getId()}")
                      if (createdBy.getName().isDefined) {
                        println(s"Created By - Name: ${createdBy.getName().get}")
                      }
                    }
                    
                    if (user.getModifiedBy().isDefined) {
                      val modifiedBy = user.getModifiedBy().get
                      println(s"Modified By - ID: ${modifiedBy.getId()}")
                      if (modifiedBy.getName().isDefined) {
                        println(s"Modified By - Name: ${modifiedBy.getName().get}")
                      }
                    }
                    
                    println("--------------------")
                  }
                } else {
                  println("No users found.")
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
          println("No response received from GetUsers API.")
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

      getUsers()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}