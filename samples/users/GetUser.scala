package samples.users

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.users.{APIException, ResponseHandler, ResponseWrapper, Users, UsersOperations}
import com.zoho.crm.api.util.{APIResponse, Choice}
import com.zoho.crm.api.HeaderMap
import com.zoho.crm.api.Initializer
import com.zoho.crm.api.users.UsersOperations.GetUserHeader

object GetUser {

  @throws[Exception]
  private def getUser(userId: Long): Unit = {
    val usersOperations = new UsersOperations()
    val headerInstance = new HeaderMap()
    
    // Add if-modified-since header
    val ifModifiedSince = java.time.OffsetDateTime.parse("2023-01-01T00:00:00Z")
    headerInstance.add(new GetUserHeader().IfModifiedSince, ifModifiedSince)
    
    val response: Option[APIResponse[ResponseHandler]] = usersOperations.getUser(userId, Option(headerInstance))

    if (response.isDefined) {
      response match {
        case Some(apiResponse) =>
          println(s"Status Code: ${apiResponse.getStatusCode}")

          apiResponse.getStatusCode match {
            case 204 =>
              println("No Content")

            case 304 =>
              println("Not Modified")

            case _ =>
              if (apiResponse.isExpected) {
                val responseHandler = apiResponse.getObject

                responseHandler match {
                  case responseWrapper: ResponseWrapper =>
                    val users = responseWrapper.getUsers()
                    if (users != null && users.nonEmpty) {
                      val user = users.head
                      
                      println("User Details:")
                      
                      // Basic user information
                      if (user.getFirstName() != null) {
                        println(s"First Name: ${user.getFirstName()}")
                      }
                      
                      if (user.getLastName() != null) {
                        println(s"Last Name: ${user.getLastName()}")
                      }
                      
                      if (user.getFullName() != null) {
                        println(s"Full Name: ${user.getFullName()}")
                      }
                      
                      if (user.getEmail() != null) {
                        println(s"Email: ${user.getEmail()}")
                      }
                      
                      if (user.getStatus() != null) {
                        println(s"Status: ${user.getStatus()}")
                      }
                      
                      if (user.getPhone() != null) {
                        println(s"Phone: ${user.getPhone()}")
                      }
                      
                      if (user.getWebsite() != null) {
                        println(s"Website: ${user.getWebsite()}")
                      }
                      
                      if (user.getTimeFormat() != null) {
                        println(s"Time Format: ${user.getTimeFormat()}")
                      }
                      
                      if (user.getDateFormat() != null) {
                        println(s"Date Format: ${user.getDateFormat()}")
                      }
                      
                      if (user.getLanguage() != null) {
                        println(s"Language: ${user.getLanguage()}")
                      }
                      
                      if (user.getLocale() != null) {
                        println(s"Locale: ${user.getLocale()}")
                      }
                      
                      // Profile information
                      if (user.getProfile() != null && user.getProfile().get.getId() != null) {
                        println(s"Profile ID: ${user.getProfile().get.getId()}")
                        if (user.getProfile().get.getName() != null) {
                          println(s"Profile Name: ${user.getProfile().get.getName()}")
                        }
                      }
                      
                      // Role information
                      if (user.getRole() != null && user.getRole().get.getId() != null) {
                        println(s"Role ID: ${user.getRole().get.getId()}")
                        if (user.getRole().get.getName() != null) {
                          println(s"Role Name: ${user.getRole().get.getName()}")
                        }
                      }
                      
                      // Reporting To information
                      if (user.getReportingTo() != null && user.getReportingTo().get.getId() != null) {
                        println(s"Reporting To ID: ${user.getReportingTo().get.getId()}")
                        if (user.getReportingTo().get.getName() != null) {
                          println(s"Reporting To Name: ${user.getReportingTo().get.getName()}")
                        }
                      }
                      
                      // Audit information
                      if (user.getCreatedBy() != null) {
                        val created = user.getCreatedBy().get
                        println(s"Created By: ${created.getName()}")
                        println(s"Created By ID: ${created.getId()}")
                      }
                      
                      if (user.getCreatedTime() != null) {
                        println(s"Created Time: ${user.getCreatedTime()}")
                      }
                      
                      if (user.getModifiedBy() != null) {
                        val modified = user.getModifiedBy().get
                        println(s"Modified By: ${modified.getName()}")
                        println(s"Modified By ID: ${modified.getId()}")
                      }
                      
                      if (user.getModifiedTime() != null) {
                        println(s"Modified Time: ${user.getModifiedTime()}")
                      }
                      
                      // Additional information
                      if (user.getId() != null) {
                        println(s"User ID: ${user.getId()}")
                      }
                      
                      if (user.getConfirm() != null) {
                        println(s"Confirmed: ${user.getConfirm()}")
                      }
                      
                      // Timezone information
                      if (user.getTimeZone() != null) {
                        println(s"Time Zone: ${user.getTimeZone()}")
                      }
                      
                      if (user.getCountryLocale() != null) {
                        println(s"Country Locale: ${user.getCountryLocale()}")
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
          }

        case None =>
          println("No response received from GetUser API.")
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

      getUser(1055806000028843012L) // Replace with actual user ID
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}