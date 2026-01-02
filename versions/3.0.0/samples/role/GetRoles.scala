package samples.role

import com.zoho.api.authenticator.{OAuthToken, Token}
import com.zoho.crm.api.dc.{DataCenter, INDataCenter}
import com.zoho.crm.api.roles.{APIException, ResponseHandler, ResponseWrapper, RolesOperations}
import com.zoho.crm.api.util.APIResponse
import com.zoho.crm.api.Initializer

object GetRoles {

  @throws[Exception]
  private def getRoles(): Unit = {
    val rolesOperations = new RolesOperations()
    
    val response: Option[APIResponse[ResponseHandler]] = rolesOperations.getRoles()

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
                val roles = responseWrapper.getRoles()
                if (roles != null) {
                  println(s"Found ${roles.size} roles:")
                  
                  roles.foreach { role =>
                    println(s"Role ID: ${role.getId()}")
                    
                    if (role.getName().isDefined) {
                      println(s"Role Name: ${role.getName().get}")
                    }
                    if (role.getDisplayLabel().isDefined) {
                      println(s"Role Display Label: ${role.getDisplayLabel().get}")
                    }
                    if (role.getForecastManager().isDefined) {
                      val forecastManager = role.getForecastManager().get
                      println(s"Forecast Manager - ID: ${forecastManager.getId()}")
                      if (forecastManager.getName().isDefined) {
                        println(s"Forecast Manager - Name: ${forecastManager.getName().get}")
                      }
                    }
                    if (role.getShareWithPeers().isDefined) {
                      println(s"Share With Peers: ${role.getShareWithPeers().get}")
                    }
                    if (role.getDescription().isDefined) {
                      println(s"Role Description: ${role.getDescription().get}")
                    }
                    if (role.getAdminUser().isDefined) {
                      println(s"Admin User: ${role.getAdminUser().get}")
                    }
                    
                    // Display reporting to information
                    if (role.getReportingTo().isDefined) {
                      val reportingTo = role.getReportingTo().get
                      println(s"Reporting To - ID: ${reportingTo.getId()}")
                      if (reportingTo.getName().isDefined) {
                        println(s"Reporting To - Name: ${reportingTo.getName().get}")
                      }
                    }
                    
                    println("--------------------")
                  }
                } else {
                  println("No roles found.")
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
          println("No response received from GetRoles API.")
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

      getRoles()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}